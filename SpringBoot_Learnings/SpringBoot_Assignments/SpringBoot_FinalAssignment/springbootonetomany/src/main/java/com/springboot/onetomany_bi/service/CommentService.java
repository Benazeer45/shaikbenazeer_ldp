package com.springboot.onetomany_bi.service;

import com.springboot.onetomany_bi.dto.Request.CommentReqDTO;
import com.springboot.onetomany_bi.dto.Response.CommentResDTO;
import com.springboot.onetomany_bi.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    List<CommentResDTO> findByPostId(Long postId);  // Return Response DTO

    CommentResDTO findById(Long id) throws ResourceNotFoundException;  // Return Response DTO

    CommentResDTO createComment(Long postId, CommentReqDTO commentRequest) throws ResourceNotFoundException;  // Return Response DTO

    CommentResDTO updateComment(Long id, CommentReqDTO commentRequest) throws ResourceNotFoundException;  // Return Response DTO

    String deleteComment(Long id) throws ResourceNotFoundException;

    String deleteCommentbyId(Long postId, Long commentId) throws ResourceNotFoundException;  // New method
}
