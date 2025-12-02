package com.example.controllers;

import com.example.transactions.model.Cart;

import java.util.ArrayList;

public class CartDataArray {
    private static final ArrayList<Cart> carts = new ArrayList<>();

    public static String add(Cart cart) {
        if (carts.stream().filter(i -> i.getCart_id() == cart.getCart_id()).findFirst().orElse(null) == null) {
            carts.add(cart);
            return "Product Added";
        } else {
            return "Id Conflict";
        }
    }

    public static ArrayList<Cart> getCarts() {
        return carts;
    }

    public static Cart getById(int id) {
        return carts.stream().filter(cart-> cart.getCart_id() == id).findFirst().orElse(null);
    }

    public static Cart update(Cart cart) {
        Cart temp_cart = carts.stream().filter(i -> i.getCart_id() == cart.getCart_id()).findFirst().orElse(null);
        if (temp_cart != null) {
            carts.remove(temp_cart);
            carts.add(cart);
        }

        return cart;
    }

    public static String deleteById(int id) {
        return carts.removeIf(product -> product.getCart_id() == id) ? "Removed" : "Not Found";
    }
}
