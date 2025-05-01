package com.webchatbackend.WebChatBackend.controller;

import com.webchatbackend.WebChatBackend.model.Users;
import com.webchatbackend.WebChatBackend.repo.UserRepo;
import com.webchatbackend.WebChatBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Autowired
    private UserRepo userRepo;

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
    public String login(@RequestBody Users user) {
        System.out.println("ID: " + userService.retrieveID(user.getUsername()));
        return userService.verify(user);
    }

    @PostMapping("/users/{id}/profile-picture")
    public ResponseEntity<String> uploadProfilePicture(@PathVariable int id, @RequestParam("file")MultipartFile file) throws IOException {
        Users user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        user.setProfilePicture(file.getBytes());
        userService.insertUser(user);
        return ResponseEntity.ok("Profile picture uploaded successfully");
    }

    @GetMapping("/users/{id}/profile-picture")
    public ResponseEntity<byte[]> uploadProfilePicture(@PathVariable int id) {
        Users user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE)
                .body(user.getProfilePicture());
    }

    @PostMapping("/retriveUserInfo")
    public Users retrieveUserInfo(@RequestBody Users user) {
        return userRepo.findByUsername(user.getUsername());
    }
}
