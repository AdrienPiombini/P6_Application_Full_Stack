package com.openclassroom.application.repositories;

import org.springframework.stereotype.Repository;

import com.openclassroom.application.entities.Post;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
