package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    //region Variables/Columns

    int cartID;
    int customerID;
    private List<Product> products = new ArrayList<>();

    //endregion

    //region Constructors
    public Cart(int cartID, int customerID) {
        this.cartID = cartID;
        this.customerID = customerID;
    }

    public Cart(){}
    //endregion

    //region Getters/Setters
    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
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
