package com.example.controllers;

import com.example.models.Category;
import java.util.ArrayList;

public class CategoryDataArray {
    private static final ArrayList<Category> categories = new ArrayList<>();

    public static String add(Category category) {
        if (categories.stream().filter(i -> i.getCategoryId() == category.getCategoryId()).findFirst().orElse(null) == null) {
            categories.add(category);
            return "Category Added";
        } else {
            return "Id Conflict";
        }
    }
    public static ArrayList<Category> getCategories() {
        return categories;
    }

    public static Category getById(int id) {
        return categories.stream().filter(category -> category.getCategoryId() == id).findFirst().orElse(null);
    }

    public static Category update(Category category) {
        Category temp_category = categories.stream().filter(i -> i.getCategoryId() == category.getCategoryId()).findFirst().orElse(null);
        if (temp_category != null) {
            categories.remove(temp_category);
            categories.add(category);
        }

        return category;
    }

    public static String deleteById(int id) {
        return categories.removeIf(category -> category.getCategoryId() == id) ? "Removed" : "Not Found";
    }
}
