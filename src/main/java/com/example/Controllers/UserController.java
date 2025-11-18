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
}