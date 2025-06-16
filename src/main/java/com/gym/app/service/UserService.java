package com.gym.app.service;

import com.gym.app.baseframework.exception.SystemException;
import com.gym.app.baseframework.exception.enums.ApiErrors;
import com.gym.app.entity.Users;
import com.gym.app.repository.UserRepo;
import com.gym.app.service.dto.TokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private UserRepo userRepo;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public Users register(Users user) {
        logger.info("User Details to Signin : Received -> {}",user.getUsername());
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        logger.info("User Details successfully added into Database -> {}", user.getUsername());
        return user;
    }

    public TokenResponse verify(Users user) throws SystemException {
        logger.info("User to Login Received -> {}",user.getUsername());
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            logger.info("User to Authenticated Received -> {}",user.getUsername());
            Users dbUser = userRepo.findByUsername(user.getUsername()).orElseThrow(()->new SystemException(ApiErrors.USER_DOESNOT_EXISTS));
            dbUser.setTokenVersion(dbUser.getTokenVersion()+1);
            userRepo.save(dbUser);
            logger.info("User to Authenticated Successfully -> {}",user.getUsername());
            String token = jwtService.generateToken(dbUser);
            TokenResponse tokenResponse = new TokenResponse();
            tokenResponse.setUsername(dbUser.getUsername());
            tokenResponse.setToken(token);
            logger.info("User Token generated Successfully -> {}",user.getUsername());
            return tokenResponse;
        }
        else {
            throw new SystemException(ApiErrors.INVALID_REQUEST);
        }
    }
}

