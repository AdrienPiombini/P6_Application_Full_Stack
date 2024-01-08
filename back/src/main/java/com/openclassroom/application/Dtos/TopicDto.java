package com.openclassroom.application.Dtos;

import com.openclassroom.application.entities.Enum.Title;
import lombok.Data;

@Data
public class TopicDto {
  private Title title;
  private String description;

}
