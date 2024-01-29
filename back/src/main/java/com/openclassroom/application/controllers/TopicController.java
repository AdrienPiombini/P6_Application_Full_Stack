package com.openclassroom.application.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.openclassroom.application.Dtos.TopicDto;
import com.openclassroom.application.entities.User;
import com.openclassroom.application.exceptions.SubscriptionException;
import com.openclassroom.application.implementations.TopicServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "topics")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TopicController {

  private final TopicServiceImpl topicService;

  /**
   *
   * @return all topics save in database
   */
  @GetMapping
  public ResponseEntity<?> getAllTopics() {
    List<TopicDto> topicDtos = topicService.getAllTopics();
    return ResponseEntity.ok().body(topicDtos);
  }

  /**
   *
   * @param topicDto
   * @return http code status 200
   * @throws SubscriptionException if the user is already subscribe to the topic
   */
  @PostMapping
  public ResponseEntity<?> subscribe(@RequestBody TopicDto topicDto) throws SubscriptionException {
    User user = topicService.subscribe(topicDto);
    if (user == null) {
      return ResponseEntity.badRequest().body("You can't subscribe this topic");
    }
    return ResponseEntity.ok().build();
  }

  /**
   *
   * @param topicDto
   * @return http code status 200
   * @throws SubscriptionException if the user was not subscribe to the topic
   */
  @PutMapping
  public ResponseEntity<?> unsubscribe(@RequestBody TopicDto topicDto) throws SubscriptionException {
    User user = topicService.unsubscribe(topicDto);
    if (user == null) {
      return ResponseEntity.badRequest().body("You can't unsubscribe this topic");
    }
    return ResponseEntity.ok().build();
  }

}
