package com.example.transactions.model;

import java.util.Date;

public class Order {
    //region Variables/Columns

    private Long customer_id;
    long order_id;
    Date order_date;
    String status;
    float total_amount;

    //endregion

    //region Constructor
    public Order(Long customer_id, long order_id, Date order_date, String status, float total_amount) {
        this.customer_id = customer_id;
        this.order_id = order_id;
        this.order_date = order_date;
        this.status = status;
        this.total_amount = total_amount;
    }

    public Order() {}

    //endregion

    //region Getters/Setters

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }
    //endregion
}
