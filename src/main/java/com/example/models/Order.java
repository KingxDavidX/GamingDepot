package com.example.models;

import java.util.Date;
import java.util.List;

public class Order {
    //region Variables/Columns

    private List<User> customerId;
    int orderId;
    Date orderDate;
    String status;
    float totalAmount;

    //endregion

    //region Constructor
    public Order(List<User> customerId, int orderId, Date orderDate, String status, float totalAmount) {
        this.customerId = customerId;
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    public Order() {}

    //endregion

    //region Getters/Setters

    public List<User> getCustomerId() {
        return customerId;
    }

    public void setCustomerId(List<User> customerId) {
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
