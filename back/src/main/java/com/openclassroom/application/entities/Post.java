package com.openclassroom.application.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Post")
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  String title;

  String content;

  @ManyToOne
  @JoinColumn(name = "topic_id")
  Topic topic;

  @ManyToOne
  @JoinColumn(name = "user_id")
  User user;

  Date created_at;

  Date updapted_at;

  @OneToMany(mappedBy = "post")
  List<Commentary> commentaries;

}
