package com.webchatbackend.WebChatBackend.service;

import com.webchatbackend.WebChatBackend.model.Users;
import com.webchatbackend.WebChatBackend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private JwtService jwtService;


    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    public Users insertUser(Users user) {
        return userRepo.save(user);
    }

    public String verify(Users user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        }

        return "User is not connected";
    }

    public int retrieveID(String username) {
        return userRepo.getCurrentUserId(username);
    }


    public Users getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }
}
