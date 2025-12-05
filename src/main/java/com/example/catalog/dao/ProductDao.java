package com.example.catalog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.example.catalog.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class ProductDao {

    private final JdbcTemplate jdbc;

    public ProductDao(@Qualifier("catalogJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }

    private RowMapper<Product> productRowMapper = (rs, rowNum) -> mapProduct(rs);

    private Product mapProduct(ResultSet rs)throws SQLException {
        Product p = new Product();
        p.setProduct_id(rs.getLong("product_id"));
        p.setProduct_title(rs.getString("product_title"));
        p.setProduct_rating(rs.getBigDecimal("product_rating"));
        p.setTotal_reviews(rs.getInt("total_reviews"));
        p.setDiscounted_price(rs.getBigDecimal("discounted_price"));
        p.setOriginal_price(rs.getBigDecimal("original_price"));
        p.setIs_best_seller(rs.getString("is_best_seller"));
        p.setIs_sponsored(rs.getString("is_sponsored"));
        p.setHas_coupon(rs.getString("has_coupon"));
        p.setSustainability_tags(rs.getString("sustainability_tags"));
        p.setProduct_image_url(rs.getString("product_image_url"));
        p.setProduct_page_url(rs.getString("product_page_url"));
        p.setProduct_category(rs.getString("product_category"));
        p.setDiscount_percentage(rs.getBigDecimal("discount_percentage"));
        p.setCategory_id(rs.getInt("category_id"));
        return p;
    }

    public List<Product> findAll(int limit, int offset) {
        String sql = "SELECT * FROM products LIMIT ? OFFSET ?";
        return jdbc.query(sql, productRowMapper, limit, offset);
    }

    public Product findById(long id) {
        String sql = "SELECT * FROM products WHERE product_id = ?";
        return jdbc.queryForObject(sql, productRowMapper, id);
    }

    public List<Product> findByCategory(String category, int limit, int offset) {
        String sql = "SELECT * FROM products WHERE product_category = ? Limit ? OFFSET ?";
        return jdbc.query(sql, productRowMapper, category, limit, offset);
    }


}
