package com.openclassroom.application.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.openclassroom.application.Dtos.TopicDto;
import com.openclassroom.application.entities.User;
import com.openclassroom.application.exceptions.SubscriptionException;
import com.openclassroom.application.implementation.TopicServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "topics")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TopicController {

  private final TopicServiceImpl topicService;

  @GetMapping
  public ResponseEntity<?> getAllTopics() {
    List<TopicDto> topicDtos = topicService.getAllTopics();
    return ResponseEntity.ok().body(topicDtos);
  }

  @PostMapping
  public ResponseEntity<?> subscribe(@RequestBody TopicDto topicDto) throws SubscriptionException {
    User user = topicService.subscribe(topicDto);
    if (user == null) {
      return ResponseEntity.badRequest().body("You can't subscribe this topic");
    }
    return ResponseEntity.ok().build();
  }

  @PutMapping
  public ResponseEntity<?> unsubscribe(@RequestBody TopicDto topicDto) throws SubscriptionException {
    User user = topicService.unsubscribe(topicDto);
    if (user == null) {
      return ResponseEntity.badRequest().body("You can't unsubscribe this topic");
    }
    return ResponseEntity.ok().build();
  }

}
