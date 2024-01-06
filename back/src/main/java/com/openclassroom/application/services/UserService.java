package com.openclassroom.application.services;

import org.springframework.http.ResponseEntity;

import com.openclassroom.application.Dtos.UserDto;
import com.openclassroom.application.entities.User;

public interface UserService {

    User retrieveUserByContext();

    User updateUser(UserDto userDto);

    void removeUser();

    ResponseEntity<?> getAllTopicsSubscribeAt();
}
