package com.example.models;

import java.util.Set;


public class Category {

    //region Variable/Products

    int categoryId;
    String name;
    String description;
    private Set<Product> products;

    //endregion

    //region Constructors

    public Category(int categoryId, String name, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    public Category() {}
    //endregion

    //region Getters/Setters
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //endregion

    public void addProduct(){
        //TODO: Implement method logic
    }

    public void removeProduct(){
        //TODO: Implement method logic
    }
    public void getProduct(){
        //TODO: Implement method logic
    }


}
