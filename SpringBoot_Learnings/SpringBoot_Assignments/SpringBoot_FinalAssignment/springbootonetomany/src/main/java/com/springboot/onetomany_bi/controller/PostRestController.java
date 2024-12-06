package com.springboot.onetomany_bi.controller;

import com.springboot.onetomany_bi.constants.Constants;
import com.springboot.onetomany_bi.dto.Request.CommentReqDTO;
import com.springboot.onetomany_bi.dto.Request.PostReqDTO;
import com.springboot.onetomany_bi.dto.Response.CommentResDTO;
import com.springboot.onetomany_bi.dto.Response.PostResDTO;
import com.springboot.onetomany_bi.exception.ResourceNotFoundException;
import com.springboot.onetomany_bi.service.PostService;
import com.springboot.onetomany_bi.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(Constants.API_VERSION_1)
public class PostRestController {

    private final PostService postService;
    private final CommentService commentService;

    public PostRestController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping("/posts")
    public ResponseEntity<Page<PostResDTO>> getAllPosts(
            @RequestParam(defaultValue = "0") Integer page,  // Default page value is 0
            @RequestParam(defaultValue = "10") Integer size,  // Default size value is 10
            @RequestParam(required = false) Boolean published,
            @RequestParam(required = false) String title
    ) {
        // page and size already have default values set, so no need to check for null
        Page<PostResDTO> posts = postService.findAll(page, size, published, title);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }


    @GetMapping("/posts/{postId}")
    public ResponseEntity<Object> getPostById(@PathVariable("postId") Long postId) {
        PostResDTO post = postService.findById(postId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping("/posts")
    public ResponseEntity<Object> createPost(@Valid @RequestBody PostReqDTO postRequest,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors().stream()
                    .map(error -> ((FieldError) error).getField() + ": " + error.getDefaultMessage())
                    .collect(Collectors.joining(", "));
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
        PostResDTO createdPost = postService.createPost(postRequest);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<Object> updatePost(@PathVariable("postId") Long postId,
                                             @Valid @RequestBody PostReqDTO postRequest,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors().stream()
                    .map(error -> ((FieldError) error).getField() + ": " + error.getDefaultMessage())
                    .collect(Collectors.joining(", "));
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
        PostResDTO updatedPost = postService.updatePost(postId, postRequest);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<Object> deletePost(@PathVariable("postId") Long postId) {
        String message = postService.deletePost(postId);
        return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<Object> createComment(@PathVariable(value = "postId") Long postId,
                                                @Valid @RequestBody CommentReqDTO commentRequest,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors().stream()
                    .map(error -> ((FieldError) error).getField() + ": " + error.getDefaultMessage())
                    .collect(Collectors.joining(", "));
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
        CommentResDTO createdComment = commentService.createComment(postId, commentRequest);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<Object> getAllCommentsByPostId(@PathVariable(value = "postId") Long postId) {
        List<CommentResDTO> comments = commentService.findByPostId(postId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long postId, @PathVariable Long commentId) {
        try {
            String response = commentService.deleteCommentbyId(postId, commentId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
