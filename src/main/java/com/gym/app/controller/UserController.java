package com.gym.app.controller;

import com.gym.app.entity.Users;
import com.gym.app.repository.UserRepo;
import com.gym.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private UserRepo userRepo;


    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return service.register(user);

    }
    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        return service.verify(user);
    }
}
