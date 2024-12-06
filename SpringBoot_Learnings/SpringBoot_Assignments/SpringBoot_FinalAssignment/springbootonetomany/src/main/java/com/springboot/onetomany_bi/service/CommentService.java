
package com.springboot.onetomany_bi.service;

import com.springboot.onetomany_bi.dto.CommentDTO;
import com.springboot.onetomany_bi.exception.ResourceNotFoundException;

import java.util.List;

public interface CommentService {

    List<CommentDTO> findByPostId(Long postId);

    CommentDTO findById(Long id) throws ResourceNotFoundException;

    CommentDTO createComment(Long postId, CommentDTO commentRequest) throws ResourceNotFoundException;

    CommentDTO updateComment(Long id, CommentDTO commentRequest) throws ResourceNotFoundException;

    String deleteComment(Long id) throws ResourceNotFoundException;

    String deleteCommentbyId(Long postId, Long commentId) throws ResourceNotFoundException;  // New method


}
