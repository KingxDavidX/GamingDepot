package com.example.Controllers;

import com.example.Models.Cart;
import com.example.Models.Product;

import java.util.ArrayList;

public class ProductDataArray {
    private static final ArrayList<Product> products = new ArrayList<>();

    public static String add(Product product) {
        if (products.stream().filter(i -> i.getId() == product.getId()).findFirst().orElse(null) == null) {
            products.add(product);
            return "Product Added";
        } else {
            return "Id Conflict";
        }
    }

    public static ArrayList<Product> getCarts() {
        return products;
    }

    public static Product getById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    public static Product update(Product product) {
        Product temp_product = products.stream().filter(i -> i.getId() == product.getId()).findFirst().orElse(null);
        if (temp_product != null) {
            products.remove(temp_product);
            products.add(product);
        }

        return product;
    }

    public static String deleteById(int id) {
        return products.removeIf(product -> product.getId() == id) ? "Removed" : "Not Found";
    }
}
