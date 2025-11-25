package com.example.Controllers;

import com.example.Models.Cart;

import java.util.ArrayList;

public class CartDataArray {
    private static final ArrayList<Cart> carts = new ArrayList<>();

    public static String add(Cart cart) {
        if (carts.stream().filter(i -> i.getCartID() == cart.getCartID()).findFirst().orElse(null) == null) {
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
        return carts.stream().filter(cart-> cart.getCartID() == id).findFirst().orElse(null);
    }

    public static Cart update(Cart cart) {
        Cart temp_cart = carts.stream().filter(i -> i.getCartID() == cart.getCartID()).findFirst().orElse(null);
        if (temp_cart != null) {
            carts.remove(temp_cart);
            carts.add(cart);
        }

        return cart;
    }

    public static String deleteById(int id) {
        return carts.removeIf(product -> product.getCartID() == id) ? "Removed" : "Not Found";
    }
}
