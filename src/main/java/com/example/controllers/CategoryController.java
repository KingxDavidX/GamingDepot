package com.example.controllers;

import com.example.catalog.model.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CategoryController {
    public CategoryController(){}

    @RequestMapping(method = RequestMethod.POST)
    public String create(@RequestBody Category product) {
        return CategoryDataArray.add(product);
    }
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Category> getAll() {
        return CategoryDataArray.getCategories();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Category findByID(@PathVariable int id) {
        return CategoryDataArray.getById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Category update(@PathVariable Category category) {
        return CategoryDataArray.update(category);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public static String deleteByID(@PathVariable int id) {
        return CategoryDataArray.deleteById(id);
    }
}
