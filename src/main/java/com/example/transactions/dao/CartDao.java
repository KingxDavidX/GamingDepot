package com.example.transactions.dao;

import com.example.catalog.dao.ProductDao;
import com.example.catalog.model.Product;
import com.example.transactions.dto.ApiMessage;
import com.example.transactions.dto.ApiResponse;
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

    //private RowMapper<CartDao> cartRowMapper = (rs, rowNum) -> mapCart(rs);

    private Cart mapCart(ResultSet rs) throws SQLException {
        Cart c = new Cart();
        c.setCart_id(rs.getLong("cart_id"));
        c.setUser_id(rs.getLong("customer_id"));
        c.setProduct_ids((List<Long>) rs.getArray("product_ids"));
        c.setQuantity(rs.getLong(("quantity")));
        return c;
    }

    public ApiResponse addCart(Cart cart) {
        String sql = "INSERT INTO cart (cart_id, user_id, product_ids, quantity) VALUES (?, ?, ?, ?)";
        jdbc.update(sql, cart.getCart_id(), cart.getUser_id(), cart.getProduct_ids(), cart.getQuantity());
        return null;
    }

    public ApiResponse updateCart(Cart cart) {
        long temp = cart.getQuantity();
        String sql = """
                 UPDATE cart
                 SET product_ids=?, quantity=?
                 WHERE cart_id=?
                 """;
        jdbc.update(sql, cart.getProduct_ids(), cart.getQuantity());
        if (cart.getQuantity() > temp) {
            return new ApiMessage("Item Added to user " + cart.getUser_id() + "'s Cart");
        } else if (cart.getQuantity() < temp){
            return new ApiMessage("Item deleted from user " + cart.getUser_id() + "'s Cart");
        }
        return new ApiMessage("No change made to user " + cart.getUser_id() + "'s Cart");
    }

}