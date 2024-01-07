package com.openclassroom.application.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.openclassroom.application.Dtos.TopicDto;
import com.openclassroom.application.entities.User;
import com.openclassroom.application.exceptions.SubscriptionException;

public interface TopicService {

  List<TopicDto> getAllTopics();

  User subscribe(TopicDto topicDto) throws SubscriptionException;

  User unsubscribe(TopicDto topicDto) throws SubscriptionException;

}
