package com.gym.app.controller;

import com.gym.app.baseframework.exception.SystemException;
import com.gym.app.entity.Users;
import com.gym.app.repository.UserRepo;
import com.gym.app.service.UserService;
import com.gym.app.service.dto.TokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService service;
    @Autowired
    private UserRepo userRepo;


    @PostMapping("/register")
    public ResponseEntity<Users> register(@RequestBody Users user) {
        logger.info("User Details:Received");
        return new ResponseEntity<>(service.register(user), HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody Users user) throws SystemException {
        logger.info("user login details: Received");
        return new ResponseEntity<>(service.verify(user),HttpStatus.OK);
    }
}
