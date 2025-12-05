package com.example.controllers;

import com.example.transactions.dao.CartDao;
import com.example.transactions.model.Cart;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartDao cartDao;

    public CartController(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    //Methods: getProductID, addProductID, deleteProductID, getTotalPrice, addTotalPrice, removeTotalPrice,


}
