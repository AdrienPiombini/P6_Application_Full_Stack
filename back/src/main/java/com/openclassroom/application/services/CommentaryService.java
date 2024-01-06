package com.openclassroom.application.services;

import com.openclassroom.application.Dtos.CommentaryDto;
import com.openclassroom.application.entities.Commentary;

public interface CommentaryService {

  Commentary createCommentary(CommentaryDto commentaryDto, Long postId);
}
