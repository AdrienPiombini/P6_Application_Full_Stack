package com.openclassroom.application.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.openclassroom.application.Dtos.TopicDto;
import com.openclassroom.application.entities.Topic;

@Service
public class TopicMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public Topic fromTopicDto(TopicDto topicDto) {
        return modelMapper.map(topicDto, Topic.class);
    }

    public TopicDto fromTopic(Topic topic) {
        return modelMapper.map(topic, TopicDto.class);
    }
}
