package com.example.controllers;

import com.example.transactions.dao.UserDao;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.transactions.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userDao.addUser(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return null;
    }


}
