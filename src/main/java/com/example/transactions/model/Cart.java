package com.example.transactions.model;

import com.example.catalog.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    //region Variables/Columns

    long cart_id;
    long customer_id;
    private List<Product> products = new ArrayList<>();

    //endregion

    //region Constructors
    public Cart(long cart_id, long customer_id) {
        this.cart_id = cart_id;
        this.customer_id = customer_id;
    }

    public Cart(){}
    //endregion

    //region Getters/Setters
    public long getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    //endregion

    public void addItem(Product product){
        this.products.add(product);
    }

    public void removeItem(Product product){
        this.products.remove(product);
    }
}
