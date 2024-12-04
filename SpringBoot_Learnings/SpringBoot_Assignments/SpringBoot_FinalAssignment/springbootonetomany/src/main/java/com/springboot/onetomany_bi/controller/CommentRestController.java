package com.springboot.onetomany_bi.controller;

import com.springboot.onetomany_bi.exception.ResourceNotFoundException;
import com.springboot.onetomany_bi.model.Comment;
import com.springboot.onetomany_bi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v2")
public class CommentRestController {

  private final CommentService commentService;

  private static final String POST_NOT_FOUND = "Post not found with id ";
  private static final String COMMENT_NOT_FOUND = "Comment not found with id ";

  @Autowired
  public CommentRestController(CommentService commentService) {
    this.commentService = commentService;
  }

  @GetMapping("/posts/{postId}/comments")
  public ResponseEntity<Object> getAllCommentsByPostId(@PathVariable(value = "postId") Long postId) {
    try {
      List<Comment> comments = commentService.findByPostId(postId);
      if (comments.isEmpty()) {
        return new ResponseEntity<>("No comments found for post ID " + postId, HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(comments, HttpStatus.OK);
    } catch (ResourceNotFoundException ex) {
      return new ResponseEntity<>(POST_NOT_FOUND + postId, HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/posts/{postId}/comments")
  public ResponseEntity<Object> createComment(@PathVariable(value = "postId") Long postId,
                                              @RequestBody Comment commentRequest) {
    if (commentRequest.getContent() == null || commentRequest.getContent().isEmpty()) {
      return new ResponseEntity<>("Content cannot be null or empty", HttpStatus.BAD_REQUEST);
    }

    try {
      Comment comment = commentService.createComment(postId, commentRequest);
      return new ResponseEntity<>(comment, HttpStatus.CREATED);
    } catch (ResourceNotFoundException ex) {
      return new ResponseEntity<>(POST_NOT_FOUND + postId, HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/posts/{postId}/comments")
  public ResponseEntity<Object> deleteAllCommentsOfPost(@PathVariable(value = "postId") Long postId) {
    try {
      commentService.deleteAllCommentsByPostId(postId);
      return new ResponseEntity<>("All comments deleted for post ID " + postId, HttpStatus.NO_CONTENT);
    } catch (ResourceNotFoundException ex) {
      return new ResponseEntity<>(POST_NOT_FOUND + postId, HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/comments/{id}")
  public ResponseEntity<Object> getCommentById(@PathVariable(value = "id") Long id) {
    try {
      Comment comment = commentService.findById(id);
      return new ResponseEntity<>(comment, HttpStatus.OK);
    } catch (ResourceNotFoundException ex) {
      return new ResponseEntity<>(COMMENT_NOT_FOUND + id, HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/comments/{id}")
  public ResponseEntity<Object> updateComment(@PathVariable("id") long id, @RequestBody Comment commentRequest) {
    if (commentRequest.getContent() == null || commentRequest.getContent().isEmpty()) {
      return new ResponseEntity<>("Content cannot be null or empty", HttpStatus.BAD_REQUEST);
    }

    try {
      Comment comment = commentService.updateComment(id, commentRequest);
      return new ResponseEntity<>(comment, HttpStatus.OK);
    } catch (ResourceNotFoundException ex) {
      return new ResponseEntity<>(COMMENT_NOT_FOUND + id, HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/comments/{id}")
  public ResponseEntity<Object> deleteComment(@PathVariable("id") long id) {
    try {
      commentService.deleteComment(id);
      return new ResponseEntity<>("Comment deleted successfully", HttpStatus.NO_CONTENT);
    } catch (ResourceNotFoundException ex) {
      return new ResponseEntity<>(COMMENT_NOT_FOUND + id, HttpStatus.NOT_FOUND);
    }
  }
}
