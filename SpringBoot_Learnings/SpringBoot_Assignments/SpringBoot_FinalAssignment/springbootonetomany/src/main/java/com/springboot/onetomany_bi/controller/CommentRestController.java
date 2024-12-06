package com.springboot.onetomany_bi.controller;

import com.springboot.onetomany_bi.constants.Constants;
import com.springboot.onetomany_bi.dto.CommentDTO;
import com.springboot.onetomany_bi.service.CommentService;
import com.springboot.onetomany_bi.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(Constants.API_VERSION_2)
public class CommentRestController {

  private final CommentService commentService;
  private final PostService postService;

  public CommentRestController(CommentService commentService, PostService postService) {
    this.commentService = commentService;
    this.postService = postService;
  }

  @GetMapping("/posts/{postId}/comments")
  public ResponseEntity<Object> getAllCommentsByPostId(@PathVariable(value = "postId") Long postId) {
    List<CommentDTO> comments = commentService.findByPostId(postId);
    return new ResponseEntity<>(comments, HttpStatus.OK);
  }

  @PostMapping("/posts/{postId}/comments")
  public ResponseEntity<Object> createComment(@PathVariable(value = "postId") Long postId,
                                              @Valid @RequestBody CommentDTO commentRequest,
                                              BindingResult bindingResult) {
    return bindingResult.hasErrors()
            ? new ResponseEntity<>(bindingResult.getAllErrors().stream()
            .map(error -> ((FieldError) error).getField() + ": " + error.getDefaultMessage())
            .collect(Collectors.joining(", ")), HttpStatus.BAD_REQUEST)
            : new ResponseEntity<>(commentService.createComment(postId, commentRequest), HttpStatus.CREATED);
  }

  @GetMapping("/comments/{id}")
  public ResponseEntity<Object> getCommentById(@PathVariable(value = "id") Long id) {
    CommentDTO comment = commentService.findById(id);
    return new ResponseEntity<>(comment, HttpStatus.OK);
  }

  @PutMapping("/comments/{id}")
  public ResponseEntity<Object> updateComment(@PathVariable("id") long id,
                                              @Valid @RequestBody CommentDTO commentRequest,
                                              BindingResult bindingResult) {
    return bindingResult.hasErrors()
            ? new ResponseEntity<>(bindingResult.getAllErrors().stream()
            .map(error -> ((FieldError) error).getField() + ": " + error.getDefaultMessage())
            .collect(Collectors.joining(", ")), HttpStatus.BAD_REQUEST)
            : new ResponseEntity<>(commentService.updateComment(id, commentRequest), HttpStatus.OK);
  }

  @DeleteMapping("/comments/{id}")
  public ResponseEntity<Object> deleteComment(@PathVariable("id") long id) {
    String responseMessage = commentService.deleteComment(id);
    return new ResponseEntity<>(responseMessage, HttpStatus.NO_CONTENT);
  }
}
