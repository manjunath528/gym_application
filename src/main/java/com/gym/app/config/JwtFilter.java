package com.gym.app.config;

import com.gym.app.baseframework.exception.SystemException;
import com.gym.app.baseframework.exception.enums.ApiErrors;
import com.gym.app.entity.Users;
import com.gym.app.repository.UserRepo;
import com.gym.app.service.JWTService;
import com.gym.app.service.MyUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;


@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    JWTService jwtService;

    @Autowired
    ApplicationContext context;

    @Autowired
    UserRepo userRepo;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            username = jwtService.extractUserName(token);
        }
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(username);

            // ✅ Fetch user correctly
            Users dbUser = userRepo.findByUsername(username).orElseThrow(() -> new RuntimeException("User Not found in the database"));

            // ✅ Token version validation
            Integer tokenVersionFromToken = jwtService.extractTokenVersion(token);
            if (!Integer.valueOf(tokenVersionFromToken).equals(dbUser.getTokenVersion())) {
                throw new RuntimeException("Token version mismatch or null");
            }

            // ✅ Validate and set authentication
            if (jwtService.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }

}
