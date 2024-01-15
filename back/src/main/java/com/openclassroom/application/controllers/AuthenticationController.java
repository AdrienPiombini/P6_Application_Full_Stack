package com.openclassroom.application.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.application.Dtos.UserDto;
import com.openclassroom.application.implementation.AuthenticationServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthenticationController {

    private final AuthenticationServiceImpl authenticationServiceImpl;

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        return authenticationServiceImpl.register(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto) {
        return authenticationServiceImpl.login(userDto);
    }

    @GetMapping("test")
    public String test() {
        return "ok";
    }

    // getSubscriptions -> List Topics

}
