package com.webchatbackend.WebChatBackend.controller;

import com.webchatbackend.WebChatBackend.model.Users;
import com.webchatbackend.WebChatBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public Users addUser(@RequestBody Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userService.insertUser(user);
    }

    @PostMapping("/login")
    public int login(@RequestBody Users user) {
        System.out.println("ID: " + userService.retrieveID(user.getUsername()));
        return userService.verify(user);
    }

}
