package com.example.transactions.model;

import java.math.BigDecimal;
import java.time.Instant;

public class Order {
    //region Variables/Columns

    private Long customer_id;
    private Long order_id;
    private Instant order_date;
    private String status;
    private BigDecimal total_amount;

    //endregion

    //region Constructor
    public Order(Long customer_id, Long order_id, Instant order_date, String status, BigDecimal total_amount) {
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

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Instant getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Instant order_date) {
        this.order_date = order_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }
    //endregion
}
