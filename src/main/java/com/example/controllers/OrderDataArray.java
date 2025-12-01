package com.example.controllers;

import com.example.models.Order;

import java.util.ArrayList;

public class OrderDataArray {
    private static final ArrayList<Order> orders = new ArrayList<>();

    public static String add(Order order) {
        if (orders.stream().filter(i -> i.getOrderId() == order.getOrderId()).findFirst().orElse(null) == null) {
            orders.add(order);
            return "Order Added";
        } else {
            return "Id Conflict";
        }
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }

    public static Order getById(int id) {
        return orders.stream().filter(order -> order.getOrderId() == id).findFirst().orElse(null);
    }

    public static Order update(Order order) {
        Order temp_order = orders.stream().filter(i -> i.getOrderId() == order.getOrderId()).findFirst().orElse(null);
        if (temp_order != null) {
            orders.remove(temp_order);
            orders.add(order);
        }

        return order;
    }

    public static String deleteById(int id) {
        return orders.removeIf(pilot -> pilot.getOrderId() == id) ? "Removed" : "Not Found";
    }
}
