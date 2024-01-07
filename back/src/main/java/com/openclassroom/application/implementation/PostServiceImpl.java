package com.openclassroom.application.implementation;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.openclassroom.application.Dtos.PostDto;

import com.openclassroom.application.entities.Post;
import com.openclassroom.application.entities.Topic;
import com.openclassroom.application.entities.User;
import com.openclassroom.application.mappers.PostMapper;
import com.openclassroom.application.repositories.PostRepository;
import com.openclassroom.application.services.PostService;
import com.openclassroom.application.services.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;
  private final PostMapper postMapper;
  private final UserService userService;

  @Override
  public Post createPost(PostDto postDto) {
    // TO update with response entity and test of not nul data
    Post post = postMapper.fromPostDto(postDto);
    User user = userService.retrieveUserByContext();
    Topic topic = new Topic(postDto.getTopic());
    post.setCreated_at(new Date());
    post.setUser(user);
    post.setTopic(topic);

    return postRepository.save(post);
  }

  @Override
  public List<PostDto> findAllSubscribePostOfOneUser() {
    User user = userService.retrieveUserByContext();
    List<Topic> topicList = user.getTopics();
    List<Post> postList = postRepository.findAllByTopicIn(topicList);
    List<PostDto> postDtoList = postList.stream().map(post -> postMapper.fromPost(post)).collect(Collectors.toList());
    return postDtoList;
  }

  @Override
  public PostDto findOnePost(Long id) {
    Optional<Post> post = postRepository.findById(id);
    if (!post.isPresent()) {
      return null;
    }
    PostDto postDto = postMapper.fromPost(post.get());
    return postDto;
  }

  @Override
  public PostDto updatePost(PostDto postDto) {
    throw new UnsupportedOperationException("Unimplemented method 'updatePost'");
  }

}
