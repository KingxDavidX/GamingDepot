package com.example.transactions.dao;

import com.example.service.PasswordService;
import com.example.transactions.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

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

    public String addUser(@RequestParam User user) {
        if (existsByUsername(user.getUsername()) || existsByEmail(user.getEmail())) {
            return "Account already exists";
        }
        String sql = "INSERT INTO users (username, email, password_hash) VALUES (?, ?, ?)";
        String hashed = passwordService.hashPassword(user.getPassword_hash());
        jdbc.update(sql, user.getUsername(), user.getEmail(), hashed);
        return "User created";
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


}
