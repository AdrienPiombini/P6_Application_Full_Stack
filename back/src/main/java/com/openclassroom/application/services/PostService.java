package com.openclassroom.application.services;

import org.springframework.http.ResponseEntity;

import com.openclassroom.application.Dtos.PostDto;
import com.openclassroom.application.entities.Post;

public interface PostService {
  ResponseEntity<?> createPost(PostDto postdDto);

  ResponseEntity<?> findAllSubscribePostOfOneUser();

  PostDto findOnePost(Long id);

  Post updatePost(PostDto postDto);

}
