package com.openclassroom.application.repositories;

import org.springframework.stereotype.Repository;

import com.openclassroom.application.entities.Topic;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
