package com.example.transactions.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    //region Variables/Columns

    private Long cart_id;
    private long customer_id;
    private List<Long> product_ids = new ArrayList<>();

    //endregion

    //region Constructors
    public Cart(Long cart_id, Long customer_id) {
        this.cart_id = cart_id;
        this.customer_id = customer_id;
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

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public List<Long> getProduct_ids() {
        return product_ids;
    }

    public void setProduct_ids(List<Long> product_ids) {
        this.product_ids = product_ids;
    }

    //endregion

    public void addItem(Long product_id){
        this.product_ids.add(product_id);
    }

    public void removeItem(Long product_id){
        this.product_ids.remove(product_id);
    }
}
