package com.springboot.onetomany_bi.controller;

import com.springboot.onetomany_bi.exception.ResourceNotFoundException;
import com.springboot.onetomany_bi.model.Comment;
import com.springboot.onetomany_bi.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.API_VERSION_V2)
public class CommentRestController {

    private final CommentService commentService;

    @Autowired
    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/posts/{id}/comments")
    public ResponseEntity<Object> getAllCommentsByPostId(@PathVariable(value = "id") Long postId) {
        List<Comment> comments = commentService.findByPostId(postId);
        return new ResponseEntity<>(comments.isEmpty() ? new Object[]{} : comments, HttpStatus.OK);
    }

    @PostMapping("/posts/{id}/comments")
    public ResponseEntity<Object> createComment(@PathVariable(value = "id") Long postId,
                                                @Valid @RequestBody Comment commentRequest,
                                                BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        Comment comment = commentService.createComment(postId, commentRequest);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @DeleteMapping("/posts/{id}/comments")
    public ResponseEntity<Object> deleteAllCommentsOfPost(@PathVariable(value = "id") Long postId) {
        commentService.deleteAllCommentsByPostId(postId);
        return new ResponseEntity<>(String.format("All comments deleted for post ID %d", postId), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Object> getCommentById(@PathVariable(value = "id") Long id) {
        Comment comment = commentService.findById(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<Object> updateComment(@PathVariable("id") long id,
                                                @Valid @RequestBody Comment commentRequest,
                                                BindingResult result) {
        return result.hasErrors() 
            ? new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST)
            : new ResponseEntity<>(commentService.updateComment(id, commentRequest), HttpStatus.OK);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Object> deleteComment(@PathVariable("id") long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.NO_CONTENT);
    }
}
