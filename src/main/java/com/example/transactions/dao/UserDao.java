package com.example.transactions.dao;

import com.example.service.PasswordService;
import com.example.transactions.dto.ApiError;
import com.example.transactions.dto.ApiMessage;
import com.example.transactions.dto.ApiResponse;
import com.example.transactions.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {

    private final JdbcTemplate jdbc;
    private final PasswordService passwordService;

    public UserDao(@Qualifier("transactionsJdbcTemplate") JdbcTemplate jdbcTemplate, PasswordService passwordService) {
        this.jdbc = jdbcTemplate;
        this.passwordService = passwordService;
    }

    private RowMapper<User> userRowMapper = (rs, rowNum) -> mapUser(rs);

    private User mapUser(ResultSet rs) throws SQLException {
        User u = new User();
        u.setUser_id(rs.getLong("user_id"));
        u.setEmail(rs.getString("email"));
        u.setUsername(rs.getString("username"));
        u.setPassword_hash(rs.getString("password_hash"));
        return u;
    }

    public ApiResponse addUser(User user) {
        if (existsByUsername(user.getUsername()) ) {
            return new ApiError("Username already exists");
        }
        if  (existsByEmail(user.getEmail()) ) {
            return new ApiError("Email already exists");
        }
        String sql = "INSERT INTO users (username, email, password_hash) VALUES (?, ?, ?)";
        String hashed = passwordService.hashPassword(user.getPassword_hash());
        jdbc.update(sql, user.getUsername(), user.getEmail(), hashed);
        return new ApiMessage("User created");
    }

    private boolean existsByUsername(String username) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
        Integer count = jdbc.queryForObject(sql, Integer.class, username);
        return count != null && count > 0;
    }

    private boolean existsByEmail(String email) {
        String sql = "SELECT COUNT(*) FROM users WHERE email = ?";
        Integer count = jdbc.queryForObject(sql, Integer.class, email);
        return count != null && count > 0;
    }

    public User authenticate(String username, String rawPassword) {
        String sql = "SELECT * FROM users WHERE username = ?";

        try {
            User user = jdbc.queryForObject(sql, userRowMapper, username);
            if (passwordService.verifyPassword(rawPassword, user.getPassword_hash())) {
                return user;
            } else {
                return null;
            }
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


}
