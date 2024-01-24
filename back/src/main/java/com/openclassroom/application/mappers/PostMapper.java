package com.openclassroom.application.mappers;

import com.openclassroom.application.Dtos.CommentaryDto;
import com.openclassroom.application.entities.Commentary;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.application.Dtos.PostDto;
import com.openclassroom.application.entities.Post;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostMapper {

  @Autowired
  CommentaryMapper commentaryMapper;
  public PostMapper() {
    modelMapper.createTypeMap(Post.class, PostDto.class)
        .addMapping(src -> src.getTopic().getTitle(), PostDto::setTopic)
        .addMapping(src -> src.getUser().getUsername(), PostDto::setUser);
  }

  private final ModelMapper modelMapper = new ModelMapper();
  public Post fromPostDto(PostDto postdDto) {
    return modelMapper.map(postdDto, Post.class);
  }

  public PostDto fromPost(Post post) {

    List<CommentaryDto> commentaryDtoList = (commentaryMapper.fromCommentaryList(post.getCommentaries()));
    for(Commentary c : post.getCommentaries()){
      commentaryMapper.fromCommentary(c);
    }
    PostDto result =  modelMapper.map(post, PostDto.class);
    result.setCommentaries(commentaryDtoList);
    return result;
  }

}
