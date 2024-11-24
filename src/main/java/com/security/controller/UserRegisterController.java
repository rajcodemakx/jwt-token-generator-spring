package com.security.controller;

import com.security.model.User;
import com.security.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserRegisterController {

    @Autowired
    private UserRegisterService userRegisterService;

    @PostMapping("/user/new/register")
    public ResponseEntity<Map<String, Object>> createNewUser(@RequestBody User user) {
        System.out.println(user);

        return ResponseEntity.ok(userRegisterService.createNewUser(user));
    }
}
