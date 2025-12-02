package com.example.transactions.model;

import java.util.Date;
import java.util.List;

public class Order {
    //region Variables/Columns

    private List<Long> customer_ids;
    long order_is;
    Date order_date;
    String status;
    float total_amount;

    //endregion

    //region Constructor
    public Order(List<Long> customer_ids, long order_is, Date order_date, String status, float total_amount) {
        this.customer_ids = customer_ids;
        this.order_is = order_is;
        this.order_date = order_date;
        this.status = status;
        this.total_amount = total_amount;
    }

    public Order() {}

    //endregion

    //region Getters/Setters

    public List<Long> getCustomer_ids() {
        return customer_ids;
    }

    public void setCustomer_ids(List<Long> customer_ids) {
        this.customer_ids = customer_ids;
    }

    public long getOrder_is() {
        return order_is;
    }

    public void setOrder_is(long order_is) {
        this.order_is = order_is;
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
