package com.AyushDwivedi.SpingBootProject.controller;

import com.AyushDwivedi.SpingBootProject.model.User;
import com.AyushDwivedi.SpingBootProject.repository.UserRepository;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
    private final UserRepository userRepo;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userRepo.save(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user){
        User existing = userRepo.findByEmail(user.getEmail());
        if (existing != null && existing.getPassword().equals(user.getPassword())) {
            return existing;
        }
        throw new RuntimeException("Invalid credentials");
    }

}
