package com.example.Models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Order {
    //region Variables/Columns
    //TODO: Add connection to user
    int customerId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int orderId;

    @Column(nullable = false)
    Date orderDate;

    @Column(nullable = false)
    String status;

    @Column(nullable = false)
    float totalAmount;
    //endregion

    //region Constructor
    public Order(int customerId, int orderId, Date orderDate, String status, float totalAmount) {
        this.customerId = customerId;
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    public Order() {}

    //endregion

    //region Getters/Setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }
    //endregion
}
