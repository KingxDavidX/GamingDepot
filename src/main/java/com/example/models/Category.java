package com.example.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    //TODO: Connect to product

    //region Variable/Products
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int categoryId;

    @Column(unique = true, nullable = false)
    String name;

    @Column(nullable = false)
    String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
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
