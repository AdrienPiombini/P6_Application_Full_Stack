package com.openclassroom.application.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.application.Dtos.PostDto;
import com.openclassroom.application.entities.Post;

@Service

public class PostMapper {
  @Autowired
  CommentaryMapper commentaryMapper;

  public PostMapper() {
    modelMapper.createTypeMap(Post.class, PostDto.class)
        .addMapping(src -> src.getTopic().getTitle(), PostDto::setTopic)
        .addMapping(src -> src.getUser().getUsername(), PostDto::setUser);

    // .addMapping(src -> commentaryMapper.fromCommentary(src.getCommentaries()),
    // PostDto::setCommentaries);

  }

  private final ModelMapper modelMapper = new ModelMapper();
  // private final PostRepository postRepository;

  public Post fromPostDto(PostDto postdDto) {
    return modelMapper.map(postdDto, Post.class);

  }

  public PostDto fromPost(Post post) {
    return modelMapper.map(post, PostDto.class);
  }

}
