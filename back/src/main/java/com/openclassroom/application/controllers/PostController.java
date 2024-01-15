package com.openclassroom.application.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.application.Dtos.CommentaryDto;
import com.openclassroom.application.Dtos.PostDto;
import com.openclassroom.application.entities.Commentary;
import com.openclassroom.application.entities.Post;
import com.openclassroom.application.implementation.CommentaryServiceImpl;
import com.openclassroom.application.implementation.PostServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("post")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PostController {

  private final PostServiceImpl postServiceImpl;

  private final CommentaryServiceImpl commentaryServiceImpl;

  @GetMapping
  public ResponseEntity<?> findAllPosts() {
    List<PostDto> postDtos = postServiceImpl.findAllSubscribePostOfOneUser();
    return ResponseEntity.ok().body(postDtos);
  }

  @GetMapping("{id}")
  public ResponseEntity<?> findOnePost(@PathVariable(name = "id") Long postId) {
    PostDto postDto = postServiceImpl.findOnePost(postId);
    if (postDto == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(postDto);
  }

  @PostMapping
  public ResponseEntity<?> createPost(@RequestBody PostDto postDto) {
    Post post = postServiceImpl.createPost(postDto);
    if (post == null) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok().body(null);
  }

  @PostMapping("{id}/commentaries")
  public ResponseEntity<?> createCommentary(@RequestBody CommentaryDto commentaryDto,
      @PathVariable(name = "id") Long postId) {
    Commentary commentary = commentaryServiceImpl.createCommentary(commentaryDto,
        postId);
    if (commentary == null) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok().build();
  }
}
