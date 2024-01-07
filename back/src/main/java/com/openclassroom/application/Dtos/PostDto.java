package com.openclassroom.application.Dtos;

import java.util.List;

import com.openclassroom.application.entities.Enum.Title;

import lombok.Data;

@Data
public class PostDto {
  private Long id;
  private String title;
  private String content;
  private Title topic;
  // private String user;
  private List<CommentaryDto> commentaries;
}
