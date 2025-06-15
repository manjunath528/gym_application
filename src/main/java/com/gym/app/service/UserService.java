package com.gym.app.service;

import com.gym.app.baseframework.exception.SystemException;
import com.gym.app.baseframework.exception.enums.ApiErrors;
import com.gym.app.entity.Users;
import com.gym.app.repository.UserRepo;
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

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private UserRepo userRepo;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return user;
    }

    public String verify(Users user) throws SystemException {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            Users dbUser = userRepo.findByUsername(user.getUsername()).orElseThrow(()->new SystemException(ApiErrors.USER_DOESNOT_EXISTS));
            dbUser.setTokenVersion(dbUser.getTokenVersion()+1);
            userRepo.save(dbUser);
            return jwtService.generateToken(dbUser);

        }
        else {
            throw new SystemException(ApiErrors.INVALID_REQUEST);
        }
    }
}

