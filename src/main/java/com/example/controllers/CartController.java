package com.example.controllers;

import com.example.models.Cart;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("cart")
public class CartController {
    public CartController() {}

    @RequestMapping(path = "", method = RequestMethod.POST)
    public String create(@RequestBody Cart cart) {
        return CartDataArray.add(cart);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Cart> getAll() {
        return CartDataArray.getCarts();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Cart findByID(@PathVariable int id) {
        return CartDataArray.getById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Cart update(@PathVariable Cart cart) {
        return CartDataArray.update(cart);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public static String deleteByID(@PathVariable int id) {
        return CartDataArray.deleteById(id);
    }
}
