package com.openclassroom.application.Dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CommentaryDto {

  private String message;
  private String user;
  private Date created_at;

}
