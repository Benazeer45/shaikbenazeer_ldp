package com.springboot.onetomany_bi.controller;

import com.springboot.onetomany_bi.exception.ResourceNotFoundException;
import com.springboot.onetomany_bi.model.Comment;
import com.springboot.onetomany_bi.model.Post;
import com.springboot.onetomany_bi.service.CommentService;
import com.springboot.onetomany_bi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PostRestController {

    // Define API version constant
    private static final String API_VERSION = "/api/v1";

    private final PostService postService;
    private final CommentService commentService;

    @Autowired
    public PostRestController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping("/")
    public ResponseEntity<String> root() {
        return new ResponseEntity<>("Welcome to the Post API", HttpStatus.OK);
    }

    @GetMapping(API_VERSION + "/posts")
    public ResponseEntity<List<Post>> getAllPosts(@RequestParam(required = false) String title) {
        List<Post> posts = postService.findAll(title);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping(API_VERSION + "/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") long id) {
        Post post = postService.findById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping(API_VERSION + "/posts")
    public ResponseEntity<Object> createPost(@Valid @RequestBody Post post, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("Validation failed", HttpStatus.BAD_REQUEST);
        }
        Post createdPost = postService.createPost(post);
        return new ResponseEntity<>("Post created successfully with ID: " + createdPost.getId(), HttpStatus.CREATED);
    }

    @PutMapping(API_VERSION + "/posts/{id}")
    public ResponseEntity<Object> updatePost(@PathVariable("id") long id, @Valid @RequestBody Post postRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("Validation failed", HttpStatus.BAD_REQUEST);
        }
        Post updatedPost = postService.updatePost(id, postRequest);
        return new ResponseEntity<>("Post updated successfully with ID: " + updatedPost.getId(), HttpStatus.OK);
    }

    @DeleteMapping(API_VERSION + "/posts/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable("id") long id) {
        postService.deletePost(id);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(API_VERSION + "/posts")
    public ResponseEntity<Object> deleteAllPosts() {
        postService.deleteAllPosts();
        return new ResponseEntity<>("All posts deleted successfully", HttpStatus.NO_CONTENT);
    }

    @GetMapping(API_VERSION + "/posts/published")
    public ResponseEntity<List<Post>> findByPublished() {
        List<Post> posts = postService.findByPublished(true);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping(API_VERSION + "/posts/{postId}/comments")
    public ResponseEntity<Object> createComment(@PathVariable("postId") Long postId, @Valid @RequestBody Comment commentRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("Validation failed", HttpStatus.BAD_REQUEST);
        }
        Comment comment = commentService.createComment(postId, commentRequest);
        return new ResponseEntity<>("Comment created successfully for post ID: " + postId, HttpStatus.CREATED);
    }

    @DeleteMapping(API_VERSION + "/posts/{postId}/comments/{commentId}")
    public ResponseEntity<Object> deleteComment(@PathVariable("postId") Long postId, @PathVariable("commentId") Long commentId) {
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment deleted successfully from post ID: " + postId, HttpStatus.NO_CONTENT);
    }
}
