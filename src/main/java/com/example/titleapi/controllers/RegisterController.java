package com.example.titleapi.controllers;

import com.example.titleapi.JWT.JwtRequest;
import com.example.titleapi.JWT.JwtResponse;
import com.example.titleapi.JWT.RefreshJwtRequest;
import com.example.titleapi.models.Role;
import com.example.titleapi.models.UserModel;
import com.example.titleapi.repository.UserRepository;
import com.example.titleapi.services.AuthService;
import jakarta.security.auth.message.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api-register")
public class RegisterController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/reg")
    public String login(@RequestBody JwtRequest userRequest) throws AuthException {
        UserModel usermodel = new UserModel(0, userRequest.getLogin(), userRequest.getPassword(), Collections.singleton(Role.USER));
        userRepository.save(usermodel);
        return "success!";
    }
}
