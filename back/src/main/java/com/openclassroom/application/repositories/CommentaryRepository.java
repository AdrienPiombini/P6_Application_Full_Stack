package com.openclassroom.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.application.entities.Commentary;

@Repository
public interface CommentaryRepository extends JpaRepository<Commentary, Long> {

}
