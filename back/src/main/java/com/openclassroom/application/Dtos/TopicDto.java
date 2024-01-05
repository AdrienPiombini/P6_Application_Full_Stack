package com.openclassroom.application.Dtos;

import com.openclassroom.application.entities.Enum.Title;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TopicDto {
  private Title title;
  private String description;

}
