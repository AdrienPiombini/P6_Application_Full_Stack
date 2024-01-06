package com.openclassroom.application.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.application.Dtos.UserDto;
import com.openclassroom.application.implementation.UserServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "user")
@AllArgsConstructor
public class UserController {

  private final UserServiceImpl userServiceImpl;

  @GetMapping
  public ResponseEntity<?> getAllSubscription() {
    return userServiceImpl.getAllTopicsSubscribeAt();
  }

  @DeleteMapping
  public ResponseEntity<?> deleteUser() {
    userServiceImpl.removeUser();
    return ResponseEntity.ok().body(null);
  }

  @PutMapping
  public ResponseEntity<?> updateUser(@RequestBody UserDto userDto) {
    userServiceImpl.updateUser(userDto);
    return ResponseEntity.ok().body(null);
  }
}
