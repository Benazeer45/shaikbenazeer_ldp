package com.example.springsecurity.service;

import com.example.springsecurity.model.Users;
import com.example.springsecurity.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo repo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepo repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public Users register(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
        return user;
    }
}
