package com.example.Controllers;

import java.util.*;

import com.example.Models.User;

public class UserDataArray {
    private static final ArrayList<User> users = new ArrayList<>();
    
    public static String add(User user) {
        if (users.stream().filter(i -> i.getUserId() == user.getUserId()).findFirst().orElse(null) == null) {
            users.add(user);
            return "User Added";
        } else {
            return "Id Conflict";
        }
    }

    
}
