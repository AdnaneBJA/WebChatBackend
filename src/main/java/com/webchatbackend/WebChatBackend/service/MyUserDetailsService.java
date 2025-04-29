package com.webchatbackend.WebChatBackend.service;

import com.webchatbackend.WebChatBackend.model.UserPrincipal;
import com.webchatbackend.WebChatBackend.model.Users;
import com.webchatbackend.WebChatBackend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);

        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("USER NOT FOUND");
        }
        return new UserPrincipal(user);
    }
}
