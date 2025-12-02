package com.example.controllers;

import com.example.catalog.dao.CategoryDao;
import com.example.catalog.model.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryDao categoryDao;

    public CategoryController(CategoryDao dao) {
        this.categoryDao = dao;
    }

    @GetMapping
    public List<Category> all() {
        return categoryDao.findAll();
    }

    @GetMapping("/{id}")
    public Category byId(@PathVariable int id) {
        return categoryDao.findById(id);
    }

    @GetMapping("/by-name")
    public Category byName(@RequestParam String name) {
        return categoryDao.findByName(name);
    }


}
