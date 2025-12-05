package com.example.transactions.dao;

import com.example.catalog.dao.ProductDao;
import com.example.catalog.model.Product;
import com.example.transactions.model.Cart;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CartDao {
    private final JdbcTemplate jdbc;
    private final ProductDao productDao;



    public CartDao(@Qualifier("transactionsJdbcTemplate") JdbcTemplate jdbc, ProductDao pDoa) {
        this.jdbc = jdbc;
        this.productDao = pDoa;
    }

    private RowMapper<CartDao> cartRowMapper = ((rs, rowNum) -> mapCart(rs));

    private Cart mapCart(ResultSet rs) throws SQLException {
        Cart c = new Cart();
        c.setCart_id(rs.getLong("cart_id"));
        c.setCustomer_id(rs.getLong("customer_id"));
        return c;
    }

    public List<Product> findAll (int limit, int offset) {
        String sql = "SELECT * FROM prodcuts LIMIT ? OFFSET ?";
        return jdbc.query(sql, cartRowMapper, limit, offset);
    }

}
