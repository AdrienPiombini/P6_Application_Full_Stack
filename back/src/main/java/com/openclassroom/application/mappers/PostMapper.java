package com.openclassroom.application.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.openclassroom.application.Dtos.PostDto;
import com.openclassroom.application.entities.Post;

@Service
public class PostMapper {

  public PostMapper() {
    modelMapper.createTypeMap(Post.class, PostDto.class)
        .addMapping(src -> src.getTopic().getTitle(), PostDto::setTopic);
  }

  private final ModelMapper modelMapper = new ModelMapper();

  public Post fromPostDto(PostDto postdDto) {
    return modelMapper.map(postdDto, Post.class);
  }

  public PostDto fromPost(Post post) {
    return modelMapper.map(post, PostDto.class);
  }

}
