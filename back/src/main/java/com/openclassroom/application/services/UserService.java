package com.openclassroom.application.services;

import java.util.List;

import com.openclassroom.application.Dtos.TopicDto;
import com.openclassroom.application.Dtos.UserDto;
import com.openclassroom.application.entities.User;

public interface UserService {

    User retrieveUserByContext();

    User updateUser(UserDto userDto);

    void removeUser();

    List<TopicDto> getAllTopicsSubscribeAt();
}
