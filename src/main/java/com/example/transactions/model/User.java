package com.example.transactions.model;

public class User {

    private long user_id;
    private String name;
    private String email;

    public User() {}

    public User(long user_id, String name, String email) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
    }

    public long getUserId() {
        return user_id;
    }

    public void setUserId(long id) {
        this.user_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void login() {
        //TODO: Implement funtionality
    }

    public void register() {
        //TODO: Implement funtionality
    }


}
