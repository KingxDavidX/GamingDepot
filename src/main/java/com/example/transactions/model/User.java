package com.example.transactions.model;

import java.util.Date;

public class User {

    private long user_id;
    private String email;
    private String password_hash;
    private String username;

    public User() {}

    public User(long user_id, String email, String password_hash, String username) {
        this.user_id = user_id;
        this.email = email;
        this.password_hash = password_hash;
        this.username = username;
    }

    //region Getters/Setters

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    //endregion

    public void login() {
        //TODO: Implement funtionality
    }

    public void register() {
        //TODO: Implement funtionality
    }


}
