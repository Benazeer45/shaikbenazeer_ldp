package com.springboot.onetomany_bi.controller;

import com.springboot.onetomany_bi.constants.Constants;
import com.springboot.onetomany_bi.dto.Request.CommentReqDTO;
import com.springboot.onetomany_bi.dto.Request.PostReqDTO;
import com.springboot.onetomany_bi.dto.Response.CommentResDTO;
import com.springboot.onetomany_bi.dto.Response.PostResDTO;
import com.springboot.onetomany_bi.exception.ResourceNotFoundException;
import com.springboot.onetomany_bi.service.PostService;
import com.springboot.onetomany_bi.service.CommentService;
import com.springboot.onetomany_bi.utils.ValidationUtils;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping(Constants.API_VERSION_1)
public class PostRestController {

    private final PostService postService;
    private final CommentService commentService;

    public PostRestController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping("")
    public Page<PostResDTO> getAllPosts(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) Boolean published,
            @RequestParam(required = false) String title
    ) {
        return postService.findAll(page, size, published, title);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Object> getPostById(@PathVariable("postId") Long postId) {
        PostResDTO post = postService.findById(postId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> createPost(@Valid @RequestBody PostReqDTO postRequest) {
        PostResDTO createdPost = postService.createPost(postRequest);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }


    @PutMapping("/{postId}")
    public ResponseEntity<Object> updatePost(@PathVariable("postId") Long postId,
                                             @Valid @RequestBody PostReqDTO postRequest,
                                             BindingResult bindingResult) {
        String errorMessage = ValidationUtils.collectValidationErrors(bindingResult);
        if (errorMessage != null) {
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }

        PostResDTO updatedPost = postService.updatePost(postId, postRequest);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Object> deletePost(@PathVariable("postId") Long postId) {
        String message = postService.deletePost(postId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/{postId}/comments")
    public ResponseEntity<Object> createComment(@PathVariable(value = "postId") Long postId,
                                                @Valid @RequestBody CommentReqDTO commentRequest,
                                                BindingResult bindingResult) {
        String errorMessage = ValidationUtils.collectValidationErrors(bindingResult);
        if (errorMessage != null) {
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }

        CommentResDTO createdComment = commentService.createComment(postId, commentRequest);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @GetMapping("/{postId}/comments")
    public ResponseEntity<Object> getAllCommentsByPostId(@PathVariable(value = "postId") Long postId) {
        List<CommentResDTO> comments = commentService.findByPostId(postId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @DeleteMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long postId, @PathVariable Long commentId) {
        try {
            String response = commentService.deleteCommentbyId(postId, commentId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
