package com.security.service;

import com.security.model.User;
import com.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class JwtTokenGeneratorService {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    public Map<String, Object> getToken(User user) {

        Map<String, Object> responseMap = new HashMap<>();

        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authenticate.isAuthenticated()) {
            String generatedToken = jwtUtil.generateToken(user.getUsername());
            responseMap.put("token",generatedToken);
        }
        return responseMap;
    }
}
