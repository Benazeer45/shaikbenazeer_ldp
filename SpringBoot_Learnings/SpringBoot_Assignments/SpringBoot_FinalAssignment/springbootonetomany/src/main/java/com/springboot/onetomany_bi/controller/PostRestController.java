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
@RequestMapping(PostRestController.API_VERSION)  // Use constant for API version in root path
public class PostRestController {

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

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts(@RequestParam(required = false) String title) {
        List<Post> posts = postService.findAll(title);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") long id) {
        Post post = postService.findById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping("/posts")
    public ResponseEntity<Object> createPost(@Valid @RequestBody Post post, BindingResult bindingResult) {
        return bindingResult.hasErrors()
            ? new ResponseEntity<>("Validation failed", HttpStatus.BAD_REQUEST)
            : new ResponseEntity<>("Post created successfully with ID: " + postService.createPost(post).getId(), HttpStatus.CREATED);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Object> updatePost(@PathVariable("id") long id, @Valid @RequestBody Post postRequest, BindingResult bindingResult) {
        return bindingResult.hasErrors()
            ? new ResponseEntity<>("Validation failed", HttpStatus.BAD_REQUEST)
            : new ResponseEntity<>("Post updated successfully with ID: " + postService.updatePost(id, postRequest).getId(), HttpStatus.OK);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable("id") long id) {
        postService.deletePost(id);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/posts")
    public ResponseEntity<Object> deleteAllPosts() {
        postService.deleteAllPosts();
        return new ResponseEntity<>("All posts deleted successfully", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/posts/published")
    public ResponseEntity<List<Post>> findByPublished() {
        List<Post> posts = postService.findByPublished(true);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<Object> createComment(@PathVariable("postId") Long postId, @Valid @RequestBody Comment commentRequest, BindingResult bindingResult) {
        return bindingResult.hasErrors()
            ? new ResponseEntity<>("Validation failed", HttpStatus.BAD_REQUEST)
            : new ResponseEntity<>("Comment created successfully for post ID: " + postId, HttpStatus.CREATED);
    }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<Object> deleteComment(@PathVariable("postId") Long postId, @PathVariable("commentId") Long commentId) {
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment deleted successfully from post ID: " + postId, HttpStatus.NO_CONTENT);
    }
}
