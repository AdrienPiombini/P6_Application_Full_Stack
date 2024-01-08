package com.openclassroom.application.implementation;

import java.util.Date;

import javax.xml.stream.events.Comment;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.openclassroom.application.Dtos.CommentaryDto;
import com.openclassroom.application.Dtos.PostDto;
import com.openclassroom.application.entities.Commentary;
import com.openclassroom.application.entities.Post;
import com.openclassroom.application.entities.User;
import com.openclassroom.application.mappers.CommentaryMapper;
import com.openclassroom.application.mappers.PostMapper;
import com.openclassroom.application.repositories.CommentaryRepository;
import com.openclassroom.application.services.CommentaryService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class CommentaryServiceImpl implements CommentaryService {

  private final CommentaryRepository commentaryRepository;
  private final PostServiceImpl postServiceImpl;
  private final UserServiceImpl userServiceImpl;
  private final PostMapper postMapper;
  private final CommentaryMapper commentaryMapper;

  @Override
  public Commentary createCommentary(CommentaryDto commentaryDto, Long postId) {
    User user = userServiceImpl.retrieveUserByContext();
    PostDto postDto = postServiceImpl.findOnePost(postId);
    if (postDto == null) {
      return null;
    }
    Post post = postMapper.fromPostDto(postDto);
    post.setUser(user);

    Commentary commentary = commentaryMapper.fromCommentaryDto(commentaryDto);
    commentary.setUser(user);
    commentary.setCreated_at(new Date());
    commentary.setPost(post);

    return commentaryRepository.save(commentary);
  }

}
