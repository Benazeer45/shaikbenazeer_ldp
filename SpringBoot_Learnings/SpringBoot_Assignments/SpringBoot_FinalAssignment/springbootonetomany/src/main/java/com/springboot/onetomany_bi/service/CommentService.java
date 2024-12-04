package com.springboot.onetomany_bi.service;

import com.springboot.onetomany_bi.exception.ResourceNotFoundException;
import com.springboot.onetomany_bi.model.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findByPostId(Long postId);

    Comment findById(Long id) throws ResourceNotFoundException;

    Comment createCommentIndependent(Comment commentRequest);


    Comment createComment(Long postId, Comment commentRequest) throws ResourceNotFoundException;

    Comment updateComment(Long id, Comment commentRequest) throws ResourceNotFoundException;

    boolean deleteComment(Long id);

    boolean deleteAllCommentsByPostId(Long postId) throws ResourceNotFoundException;
}
