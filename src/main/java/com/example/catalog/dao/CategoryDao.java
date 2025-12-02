package com.example.catalog.dao;

import com.example.catalog.model.Category;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoryDao {
    private final JdbcTemplate jdbc;

    public CategoryDao(@Qualifier("catalogJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }

    private RowMapper<Category> categoryRowMapper = (rs, rowNum) -> mapCategory(rs);

    private Category mapCategory(ResultSet rs) throws SQLException {
        Category c = new Category();
        c.setCategory_id(rs.getInt("category_id"));
        c.setName(rs.getString("name"));
        c.setDescription(rs.getString("description"));
        return c;
    }

    public List<Category> findAll() {
        String sql = "SELECT category_id, name, description FROM categories";
        return jdbc.query(sql, categoryRowMapper);
    }

    public Category findById(int id) {
        String sql = "SELECT category_id, name, description FROM categories WHERE category_id = ?";
        return jdbc.queryForObject(sql, categoryRowMapper, id);
    }

    public Category findByName(String name) {
        String sql = "SELECT category_id, name, description FROM categories WHERE name = ?";
        return jdbc.queryForObject(sql, categoryRowMapper, name);
    }

}
