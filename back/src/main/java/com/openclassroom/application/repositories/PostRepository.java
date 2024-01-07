package com.openclassroom.application.repositories;

import org.springframework.stereotype.Repository;

import com.openclassroom.application.entities.Post;
import com.openclassroom.application.entities.Topic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

  List<Post> findAllByTopicIn(List<Topic> topics);

  // Post findByTitlePost(Title Title);

}
