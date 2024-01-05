package com.openclassroom.application.services;

import org.springframework.http.ResponseEntity;

import com.openclassroom.application.Dtos.UserDto;

public interface AuthenticationService {

  ResponseEntity<?> register(UserDto userDto);

  ResponseEntity<?> login(UserDto userDto);

}
