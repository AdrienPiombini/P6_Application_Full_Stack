package com.openclassroom.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.application.Dtos.UserDto;
import com.openclassroom.application.entities.User;
import com.openclassroom.application.repositories.UserRepository;
import com.openclassroom.application.services.UserService;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService UserService;

    @GetMapping("AllUser")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> register(@RequestBody UserDto userDto ) {
        RegistrationResponse response = new RegistrationResponse();
        userRepository.save(null)
        return ResponseEntity.ok().body(response);
    }

}
