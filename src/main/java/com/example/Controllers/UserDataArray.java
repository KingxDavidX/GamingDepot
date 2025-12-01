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

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static User getById(int id) {
        return users.stream().filter(user-> user.getUserId() == id).findFirst().orElse(null);
    }

    public static User update(User user) {
        User temp_users= UserDataArray.users.stream().filter(i -> i.getUserId() == user.getUserId()).findFirst().orElse(null);
        if (user != null) {
            users.remove(user);
            users.add(user);
        }

        return user;
    }

    public static String deleteById(int id) {
        return users.removeIf(user-> user.getUserId() == id) ? "Removed" : "Not Found";
    }


}
