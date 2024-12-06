package com.springboot.onetomany_bi.controller;

import com.springboot.onetomany_bi.constants.Constants;
import com.springboot.onetomany_bi.dto.CommentDTO;
import com.springboot.onetomany_bi.dto.PostDTO;
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
    public ResponseEntity<Page<PostDTO>> getAllPosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<PostDTO> posts = postService.findAllPaginated(page, size);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }


    @GetMapping("/posts/{postId}")
    public ResponseEntity<Object> getPostById(@PathVariable("postId") Long postId) {
        PostDTO post = postService.findById(postId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping("/posts")
    public ResponseEntity<Object> createPost(@Valid @RequestBody PostDTO postRequest,
                                             BindingResult bindingResult) {
        return bindingResult.hasErrors()
                ? new ResponseEntity<>(bindingResult.getAllErrors().stream()
                .map(error -> ((FieldError) error).getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", ")), HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(postService.createPost(postRequest), HttpStatus.CREATED);
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<Object> updatePost(@PathVariable("postId") Long postId,
                                             @Valid @RequestBody PostDTO postRequest,
                                             BindingResult bindingResult) {
        return bindingResult.hasErrors()
                ? new ResponseEntity<>(bindingResult.getAllErrors().stream()
                .map(error -> ((FieldError) error).getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", ")), HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(postService.updatePost(postId, postRequest), HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<Object> deletePost(@PathVariable("postId") Long postId) {
        String message = postService.deletePost(postId);
        return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
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

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<Object> getAllCommentsByPostId(@PathVariable(value = "postId") Long postId) {
        List<CommentDTO> comments = commentService.findByPostId(postId);
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

    @GetMapping("/filter")
    public ResponseEntity<List<PostDTO>> filterPosts(
            @RequestParam(required = false) Boolean published,
            @RequestParam(required = false) String title
    ) {
        List<PostDTO> posts = postService.findFilteredPosts(published, title);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

}
