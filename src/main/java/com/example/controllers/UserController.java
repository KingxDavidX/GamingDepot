package com.example.controllers;

import com.example.security.JwtUtil;
import com.example.transactions.dao.UserDao;
import com.example.transactions.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.transactions.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserDao userDao;
    private final JwtUtil jwtUtil;

    public UserController(UserDao userDao,  JwtUtil jwtUtil) {
        this.userDao = userDao;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        ApiResponse response = userDao.addUser(user);

        if (response instanceof ApiMessage) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User authenticated = userDao.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        if (authenticated != null) {
            String token = jwtUtil.generateToken(authenticated.getUsername(), authenticated.getUser_id());
            UserDTO dto = new UserDTO(authenticated);
            return ResponseEntity.ok(new LoginResponse(token, dto));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiError("Invalid username or password"));
        }
    }


}
