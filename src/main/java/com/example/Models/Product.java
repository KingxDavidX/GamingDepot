package com.example.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    //TODO: Add connection to cart
    //region Variables/Colums
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int productId;

    @Column(nullable = false)
    String productName;

    @Column(nullable = false)
    String details;

    @Column(nullable = false)
    int price;
    //endregion

    //region Constructors
    public Product(int productId, String productName, String details, int price) {
        this.productId = productId;
        this.productName = productName;
        this.details = details;
        this.price = price;
    }

    public Product() {}

    //endregion

    //region Getters/Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    //endregion

    public void sellProduct() {
        //TODO: Implement method logic
    }

    public void addToCart(){
        //TODO: Implement method logic
    }

    public void removeFromCart(){
        //TODO: Implemment method logic
    }

    public void buyProduct(){
        //TODO: Implement Method logic
    }
}
