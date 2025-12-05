package com.example.transactions.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    //region Variables/Columns

    private Long cart_id;
    private Long user_id;
    private List<Long> product_ids = new ArrayList<>();
    private Long quantity;

    //endregion

    //region Constructors
    public Cart(Long cart_id, Long user_id) {
        this.cart_id = cart_id;
        this.user_id = user_id;
    }

    public Cart(){}
    //endregion

    //region Getters/Setters
    public Long getCart_id() {
        return cart_id;
    }

    public void setCart_id(Long cart_id) {
        this.cart_id = cart_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public List<Long> getProduct_ids() {
        return product_ids;
    }

    public void setProduct_ids(List<Long> product_ids) {
        this.product_ids = product_ids;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    //endregion

    public void addItem(Long product_id){
        this.product_ids.add(product_id);
    }

    public void removeItem(Long product_id){
        this.product_ids.remove(product_id);
    }
}
