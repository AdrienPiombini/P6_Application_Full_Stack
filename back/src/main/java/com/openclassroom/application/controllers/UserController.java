package com.openclassroom.application.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.application.Dtos.TopicDto;
import com.openclassroom.application.Dtos.UserDto;
import com.openclassroom.application.entities.User;
import com.openclassroom.application.implementation.UserServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "user")
@AllArgsConstructor
@CrossOrigin("*")
public class UserController {

  private final UserServiceImpl userServiceImpl;

  @GetMapping
  public ResponseEntity<?> getProfile(){
    UserDto userDto = userServiceImpl.getProfile();
    return ResponseEntity.ok().body(userDto);
  }

  @GetMapping("/topics")
  public ResponseEntity<?> getAllSubscription() {
    List<TopicDto> topicDtos = userServiceImpl.getAllTopicsSubscribeAt();
    return ResponseEntity.ok().body(topicDtos);
  }

  @DeleteMapping
  public ResponseEntity<?> deleteUser() {
    userServiceImpl.removeUser();
    return ResponseEntity.ok().build();
  }

  @PutMapping
  public ResponseEntity<?> updateUser(@RequestBody UserDto userDto) {
    User user = userServiceImpl.updateUser(userDto);
    if (user == null) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok().build();
  }
}
