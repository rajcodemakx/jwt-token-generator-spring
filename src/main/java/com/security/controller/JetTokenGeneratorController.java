package com.security.controller;

import com.security.model.User;
import com.security.service.JwtTokenGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class JetTokenGeneratorController {

    @Autowired
    JwtTokenGeneratorService jwtTokenGeneratorservice;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> getToken(@RequestBody User user) {
        return ResponseEntity.ok(jwtTokenGeneratorservice.getToken(user));
    }
}
