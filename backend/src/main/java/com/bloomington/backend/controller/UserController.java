package com.bloomington.backend.controller;

import com.bloomington.backend.model.User;
import com.bloomington.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userRepo.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setProfilePhotoUrl(updatedUser.getProfilePhotoUrl());
            return ResponseEntity.ok(userRepo.save(user));
        }).orElse(ResponseEntity.notFound().build());
    }
}