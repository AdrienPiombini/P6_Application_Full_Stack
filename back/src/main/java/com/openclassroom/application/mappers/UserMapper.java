package com.openclassroom.application.mappers;

import com.openclassroom.application.Dtos.PostDto;
import com.openclassroom.application.entities.Post;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import com.openclassroom.application.Dtos.UserDto;
import com.openclassroom.application.entities.User;

@Service
public class UserMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public UserMapper() {
        modelMapper.createTypeMap(User.class, UserDto.class)
                .addMapping(src -> src.getUsername(), UserDto::setEmail)
                .addMapping(src -> src.getEmail(), UserDto::setUsername);
    }


    public User fromUserDto(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    public UserDto fromUser(User user) {
        return modelMapper.map(user, UserDto.class);
    }

}
