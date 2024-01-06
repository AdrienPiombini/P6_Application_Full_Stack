package com.openclassroom.application.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.openclassroom.application.Dtos.TopicDto;
import com.openclassroom.application.entities.Topic;
import com.openclassroom.application.entities.User;
import com.openclassroom.application.exceptions.SubscriptionException;
import com.openclassroom.application.mappers.TopicMapper;
import com.openclassroom.application.repositories.TopicRepository;
import com.openclassroom.application.repositories.UserRepository;
import com.openclassroom.application.services.TopicService;
import com.openclassroom.application.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

  private final TopicRepository topicRepository;
  private final TopicMapper topicMapper;
  private final UserService userService;
  private final UserRepository userRepository;

  @Override
  public ResponseEntity<?> getAllTopics() {
    List<Topic> topics = topicRepository.findAll();
    List<TopicDto> topicDtosList = topics.stream().map(topic -> topicMapper.fromTopic(topic))
        .collect(Collectors.toList());
    return ResponseEntity.ok().body(topicDtosList);
  }

  @Override
  public ResponseEntity<?> subscribe(TopicDto topicDto) throws SubscriptionException {
    User user = userService.retrieveUserByContext();
    Topic topic = topicMapper.fromTopicDto(topicDto);
    List<Topic> userTopics = user.getTopics();

    if (userTopics.contains(topic)) {
      return ResponseEntity.badRequest().body("You can't subscribe this topic");
      // throw new SubscriptionException("You can't subscribe this topic");
    }

    userTopics.add(topic);
    userRepository.save(user);
    return ResponseEntity.ok().body(null);
  }

  @Override
  public ResponseEntity<?> unsubscribe(TopicDto topicDto) throws SubscriptionException {
    User user = userService.retrieveUserByContext();
    Topic topic = topicMapper.fromTopicDto(topicDto);
    List<Topic> userTopics = user.getTopics();

    if (!userTopics.contains(topic)) {
      return ResponseEntity.badRequest().body("You can't unsubscribe this topic");
      // throw new SubscriptionException("You can't unsubscribe this topic");
    }
    userTopics.remove(topic);
    userRepository.save(user);
    return ResponseEntity.ok().body(null);
  }

}
