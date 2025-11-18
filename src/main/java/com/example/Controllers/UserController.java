package com.example.Controllers;

import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.Models.User;

@RestController
@RequestMapping("/users")
public class UserController {


    @RequestMapping(path = "", method = RequestMethod.POST)
    public String create(@RequestBody User user) {

        return UserDataArray.add(user);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<User> getAll() {
        return UserDataArray.getUsers();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public User findByID(@PathVariable int id) {
        return UserDataArray.getById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public User update(@PathVariable User user) {
        return UserDataArray.update(user);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public static String deleteByID(@PathVariable int id) {
        return UserDataArray.deleteById(id);
    }
}