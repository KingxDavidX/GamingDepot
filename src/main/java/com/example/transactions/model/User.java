package com.example.transactions.model;

import java.util.Date;

public class User {

    private long user_id;
    private String email;
    private String password_hash;
    private String first_name;
    private String last_name;
    private Date Created_at;

    public User() {}

    public User(long user_id, String email, String password_hash, String first_name, String last_name, Date created_at) {
        this.user_id = user_id;
        this.email = email;
        this.password_hash = password_hash;
        this.first_name = first_name;
        this.last_name = last_name;
        this.Created_at = created_at;
    }
    
    //region Getters/Setters

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long id) {
        this.user_id = id;
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getCreated_at() {
        return Created_at;
    }

    public void setCreated_at(Date created_at) {
        Created_at = created_at;
    }

    //endregion

    public void login() {
        //TODO: Implement funtionality
    }

    public void register() {
        //TODO: Implement funtionality
    }


}
