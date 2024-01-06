package com.openclassroom.application.services;

import org.springframework.http.ResponseEntity;

import com.openclassroom.application.Dtos.TopicDto;
import com.openclassroom.application.exceptions.SubscriptionException;

public interface TopicService {

  ResponseEntity<?> getAllTopics();

  ResponseEntity<?> subscribe(TopicDto topicDto) throws SubscriptionException;

  ResponseEntity<?> unsubscribe(TopicDto topicDto) throws SubscriptionException;

}
