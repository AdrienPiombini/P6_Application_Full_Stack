package com.openclassroom.application.implementation;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.openclassroom.application.entities.User;
import com.openclassroom.application.repositories.UserRepository;
import com.openclassroom.application.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public User retrieveUserByContext() {
    String authEmail = SecurityContextHolder.getContext().getAuthentication().getName();
    Optional<User> userModel = userRepository.findByEmail(authEmail);
    if (!userModel.isPresent()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    return userModel.get();
  }
}
