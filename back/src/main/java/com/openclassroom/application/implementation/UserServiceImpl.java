package com.openclassroom.application.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.openclassroom.application.mappers.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.openclassroom.application.Dtos.TopicDto;
import com.openclassroom.application.Dtos.UserDto;
import com.openclassroom.application.entities.Topic;
import com.openclassroom.application.entities.User;
import com.openclassroom.application.mappers.TopicMapper;
import com.openclassroom.application.repositories.UserRepository;
import com.openclassroom.application.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final TopicMapper topicMapper;
  private final UserMapper userMapper;

  public User retrieveUserByContext() {
    String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
    Optional<User> user = userRepository.findByEmail(userEmail);
    if (!user.isPresent()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    return user.get();
  }

  public UserDto getProfile(){
    User user = retrieveUserByContext();
    UserDto userDto = userMapper.fromUser(user);
    return userDto;
  }

  @Override
  public User updateUser(UserDto userDto) {
    String authEmail = SecurityContextHolder.getContext().getAuthentication().getName();
    User user = userRepository.findByEmail(authEmail).get();
    user.setEmail(userDto.getEmail());
    user.setUsername(userDto.getUsername());
    return userRepository.save(user);
  }

  @Override
  public void removeUser() {
    User user = retrieveUserByContext();
    // To complete by remove the validatiof of the token
    userRepository.delete(user);
  }

  @Override
  public List<TopicDto> getAllTopicsSubscribeAt() {
    User user = retrieveUserByContext();
    List<Topic> topics = user.getTopics();
    List<TopicDto> topicDtosList = topics.stream().map(topic -> topicMapper.fromTopic(topic))
        .collect(Collectors.toList());
    return topicDtosList;
  }
}
