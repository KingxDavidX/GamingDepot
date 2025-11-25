package com.example.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name= "cart")
public class Cart {

    //region Variables/Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cartID;

    //TODO: Add connection to customer and Order
    int customerID;

    @ManyToMany
    @JoinTable(name = "productId", referencedColumnName = "cartID")
    private List<Product> productID;
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
    //endregion

    public void addItem(){
        //TODO: Implement method logic
    }

    public void removeItem(){
        //TODO: Implement Method logic
    }
}
