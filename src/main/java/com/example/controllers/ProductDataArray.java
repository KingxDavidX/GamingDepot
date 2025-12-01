package com.example.controllers;

import com.example.models.Product;

import java.util.ArrayList;

public class ProductDataArray {
    private static final ArrayList<Product> products = new ArrayList<>();

    public static String add(Product product) {
        if (products.stream().filter(i -> i.getProductId() == product.getProductId()).findFirst().orElse(null) == null) {
            products.add(product);
            return "Product Added";
        } else {
            return "Id Conflict";
        }
    }

    public static ArrayList<Product> getCarts() {
        return products;
    }

    public static Product getById(int productId) {
        return products.stream().filter(product -> product.getProductId() == productId).findFirst().orElse(null);
    }

    public static Product update(Product product) {
        Product temp_product = products.stream().filter(i -> i.getProductId() == product.getProductId()).findFirst().orElse(null);
        if (temp_product != null) {
            products.remove(temp_product);
            products.add(product);
        }

        return product;
    }

    public static String deleteById(int productId) {
        return products.removeIf(product -> product.getProductId() == productId) ? "Removed" : "Not Found";
    }
}
