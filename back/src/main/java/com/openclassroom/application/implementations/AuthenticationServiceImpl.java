package com.openclassroom.application.implementations;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.openclassroom.application.Dtos.UserDto;
import com.openclassroom.application.entities.User;
import com.openclassroom.application.entities.Enum.Role;
import com.openclassroom.application.mappers.UserMapper;
import com.openclassroom.application.repositories.UserRepository;
import com.openclassroom.application.services.AuthenticationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
  private final JwtService jwtService;
  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;

  @Override
  public ResponseEntity<?> register(UserDto userDto) {
    if (userDto.getEmail() == null || userDto.getPassword() == null || userDto.getUsername() == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data is missing !");
    }

    Optional<User> userAlreadyExist = userRepository.findByEmail(userDto.getEmail());
    if (userAlreadyExist.isPresent()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already taken");
    }

    User user = userMapper.fromUserDto(userDto);
    user.setRole(Role.USER);
    user.setPassword(passwordEncoder.encode(userDto.getPassword()));
    userRepository.save(user);
    String token = jwtService.generateToken(user);
    Map<String, String> response = new HashMap<>();
    response.put("token", token);
    return ResponseEntity.ok().body(response);
  }


  @Override
  public ResponseEntity<?> login(UserDto userDto) {
    try {
      Authentication authentication = new UsernamePasswordAuthenticationToken(userDto.getEmail(),
          userDto.getPassword());
      authenticationManager.authenticate(authentication);
      User user = userRepository.findByEmail(userDto.getEmail()).get();
      String token = jwtService.generateToken(user);

      Map<String, String> response = new HashMap<>();
      response.put("token", token);

      return ResponseEntity.ok().body(response);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Bad Credentials");
    }
  }

}
