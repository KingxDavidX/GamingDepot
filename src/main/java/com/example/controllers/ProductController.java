package com.example.controllers;

import com.example.catalog.dao.ProductDao;
import com.example.catalog.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductDao productDao;

    public  ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @GetMapping("/{limit}/{offset}")
    public List<Product> all(@PathVariable int limit, @PathVariable int offset) {
        return productDao.findAll(limit, offset);
    }

    @GetMapping("/{id}")
    public Product byId(@PathVariable int id) {
        return productDao.findById(id);
    }

    @GetMapping("/{category}/{limit}/{offset}")
    public List<Product> byCategory(@PathVariable String category, @PathVariable int limit, @PathVariable int offset) {
        return productDao.findByCategory(category, limit, offset);
    }

}