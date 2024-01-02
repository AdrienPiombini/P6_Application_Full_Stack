package com.openclassroom.application.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.openclassroom.application.Dtos.UserDto;
import com.openclassroom.application.entities.Role;
import com.openclassroom.application.entities.User;

import com.openclassroom.application.mappers.UserMapper;
import com.openclassroom.application.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<?> register(UserDto userDto) {

        Optional<User> userAlreadyExist = userRepository.findByEmail(userDto.getEmail());
        if (userAlreadyExist.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already taken");
        }

        if (userDto.getEmail() == null || userDto.getPassword() == null || userDto.getUsername() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data is missing !");
        }

        User user = userMapper.fromUserDto(userDto);
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
        String token = jwtService.generateToken(user);
        return ResponseEntity.ok().body(token);
    }

    public ResponseEntity<?> login(UserDto userDto) {
        // TO COMPLETE
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDto.getEmail(),
                userDto.getPassword());
        authenticationManager.authenticate(authentication);
        Optional<User> user = userRepository.findByEmail(userDto.getEmail());
        String token = jwtService.generateToken(user.get());
        return ResponseEntity.ok().body(token);
    }
}
