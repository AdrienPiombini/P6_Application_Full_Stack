package com.openclassroom.application.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.application.Dtos.TopicDto;
import com.openclassroom.application.exceptions.SubscriptionException;
import com.openclassroom.application.implementation.TopicServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "topics")
@RequiredArgsConstructor
public class TopicController {

  private final TopicServiceImpl topicService;

  @GetMapping
  public ResponseEntity<?> getAllTopics() {
    return topicService.getAllTopics();
  }

  @PostMapping
  public ResponseEntity<?> subscribe(@RequestBody TopicDto topicDto) throws SubscriptionException {
    return topicService.subscribe(topicDto);
  }

  @DeleteMapping
  public ResponseEntity<?> unsubscribe(@RequestBody TopicDto topicDto) throws SubscriptionException {
    return topicService.unsubscribe(topicDto);
  }

}
