package com.openclassroom.application.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.openclassroom.application.Dtos.TopicDto;
import com.openclassroom.application.exceptions.SubscriptionException;

public interface TopicService {

  List<TopicDto> getAllTopics();

  ResponseEntity<?> subscribe(TopicDto topicDto) throws SubscriptionException;

  ResponseEntity<?> unsubscribe(TopicDto topicDto) throws SubscriptionException;

}
