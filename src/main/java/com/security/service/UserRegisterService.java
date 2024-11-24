package com.security.service;

import com.security.model.User;
import com.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserRegisterService {


    @Autowired
    private UserRepository userRegisterRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Map<String, Object> createNewUser(User user) {
        Map<String, Object> responseMap = new HashMap<>();
        if (user == null) {
            responseMap.put("error", "No data found");
            return responseMap;
        }


        String userPassword = user.getPassword();
        String encodedPassword = passwordEncoder.encode(userPassword);
        user.setPassword(encodedPassword);
        User userRepo = userRegisterRepository.save(user);
        boolean isCreated = userRepo != null ? true : false;
        String message = isCreated ? "created successfully" : " unsuccessfully";
        responseMap.put("message", message);
        return responseMap;
    }
}
