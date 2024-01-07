package com.openclassroom.application.services;

import java.util.List;

import com.openclassroom.application.Dtos.PostDto;
import com.openclassroom.application.entities.Post;

public interface PostService {
  Post createPost(PostDto postdDto);

  List<PostDto> findAllSubscribePostOfOneUser();

  PostDto findOnePost(Long id);

  PostDto updatePost(PostDto postDto);

}
