package com.springboot.onetomany_bi.controller;

import com.springboot.onetomany_bi.constants.Constants;
import com.springboot.onetomany_bi.dto.Request.CommentReqDTO;
import com.springboot.onetomany_bi.dto.Response.CommentResDTO;
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
  public ResponseEntity<List<CommentResDTO>> getAllCommentsByPostId(@PathVariable(value = "postId") Long postId) {
    List<CommentResDTO> comments = commentService.findByPostId(postId);
    return new ResponseEntity<>(comments, HttpStatus.OK);
  }

  @PostMapping("/posts/{postId}/comments")
  public ResponseEntity<Object> createComment(@PathVariable(value = "postId") Long postId,
                                              @Valid @RequestBody CommentReqDTO commentRequest,
                                              BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      String errors = bindingResult.getAllErrors().stream()
              .map(error -> ((FieldError) error).getField() + ": " + error.getDefaultMessage())
              .collect(Collectors.joining(", "));
      return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    CommentResDTO createdComment = commentService.createComment(postId, commentRequest);
    return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
  }

  @GetMapping("/comments/{id}")
  public ResponseEntity<CommentResDTO> getCommentById(@PathVariable(value = "id") Long id) {
    CommentResDTO comment = commentService.findById(id);
    return new ResponseEntity<>(comment, HttpStatus.OK);
  }

  @PutMapping("/comments/{id}")
  public ResponseEntity<Object> updateComment(@PathVariable("id") long id,
                                              @Valid @RequestBody CommentReqDTO commentRequest,
                                              BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      String errors = bindingResult.getAllErrors().stream()
              .map(error -> ((FieldError) error).getField() + ": " + error.getDefaultMessage())
              .collect(Collectors.joining(", "));
      return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    CommentResDTO updatedComment = commentService.updateComment(id, commentRequest);
    return new ResponseEntity<>(updatedComment, HttpStatus.OK);
  }

  @DeleteMapping("/comments/{id}")
  public ResponseEntity<Object> deleteComment(@PathVariable("id") long id) {
    String responseMessage = commentService.deleteComment(id);
    return new ResponseEntity<>(responseMessage, HttpStatus.NO_CONTENT);
  }
}
