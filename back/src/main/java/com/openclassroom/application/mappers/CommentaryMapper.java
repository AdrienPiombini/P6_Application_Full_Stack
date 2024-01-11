package com.openclassroom.application.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.openclassroom.application.Dtos.CommentaryDto;

import com.openclassroom.application.entities.Commentary;

@Service
public class CommentaryMapper {
  public CommentaryMapper() {
    modelMapper.createTypeMap(Commentary.class, CommentaryDto.class)
        .addMapping(src -> src.getUser().getUsername(), CommentaryDto::setUser);
  }

  private final ModelMapper modelMapper = new ModelMapper();

  public Commentary fromCommentaryDto(CommentaryDto commentaryDto) {
    return modelMapper.map(commentaryDto, Commentary.class);
  }

  public CommentaryDto fromCommentary(Commentary commentary) {
    return modelMapper.map(commentary, CommentaryDto.class);
  }
}
