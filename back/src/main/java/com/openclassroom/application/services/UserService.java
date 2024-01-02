package com.openclassroom.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.openclassroom.application.Dtos.UserDto;
import com.openclassroom.application.controllers.RegistrationResponse;
import com.openclassroom.application.mappers.UserMapper;
import com.openclassroom.application.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public ResponseEntity<RegistrationResponse> register(UserDto userDto) {

        User user = userMapper.toDomain(userDto);
        userRepository.save(user);
        return null;

    }
}
