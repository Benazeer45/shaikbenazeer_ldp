package com.springboot.onetomany_bi.controller;

import java.util.List;

import com.springboot.onetomany_bi.exception.ResourceNotFoundException;
import com.springboot.onetomany_bi.model.Comment;
import com.springboot.onetomany_bi.model.Post;
import com.springboot.onetomany_bi.service.CommentService;
import com.springboot.onetomany_bi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PostRestController {

    private final CommentService commentService;
    private final PostService postService;

    @Autowired
    public PostRestController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts(@RequestParam(required = false) String title) {
        List<Post> posts = postService.findAll(title);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") long id) throws ResourceNotFoundException {
        Post post = postService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + id));
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping("/posts")
    public ResponseEntity<Object> createPost(@RequestBody Post post) {
        if (post.getTitle() == null || post.getTitle().isEmpty()) {
            return new ResponseEntity<>("Title cannot be null or empty", HttpStatus.BAD_REQUEST);
        }
        if (post.getDescription() == null || post.getDescription().isEmpty()) {
            return new ResponseEntity<>("Description cannot be null or empty", HttpStatus.BAD_REQUEST);
        }

        Post createdPost = postService.createPost(post);
        return new ResponseEntity<>("Post created successfully with ID: " + createdPost.getId(), HttpStatus.CREATED);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Object> updatePost(@PathVariable("id") long id, @RequestBody Post postRequest) throws ResourceNotFoundException {
        Post updatedPost = postService.updatePost(id, postRequest);
        return new ResponseEntity<>("Post updated successfully with ID: " + updatedPost.getId(), HttpStatus.OK);
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
    public ResponseEntity<Object> createComment(@PathVariable("postId") Long postId, @RequestBody Comment commentRequest) throws ResourceNotFoundException {
        if (commentRequest.getContent() == null || commentRequest.getContent().isEmpty()) {
            return new ResponseEntity<>("Content cannot be null or empty", HttpStatus.BAD_REQUEST);
        }

        Post post = postService.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + postId));
        commentRequest.setPost(post);
        Comment comment = commentService.createComment(postId, commentRequest);

        post.getComments().add(comment);

        postService.updatePost(post.getId(), post);

        return new ResponseEntity<>("Comment created successfully for post ID: " + postId, HttpStatus.CREATED);
    }



    public ResponseEntity<Object> deleteComment(Long postId, Long commentId) throws ResourceNotFoundException {
        Post post = postService.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + postId));

        Comment comment = commentService.findById(commentId);

        if (comment == null) {
            throw new ResourceNotFoundException("Cannot read the comment");
        }

        post.getComments().remove(comment);
        postService.updatePost(post.getId(), post);
        commentService.deleteComment(commentId);

        return new ResponseEntity<>("Comment deleted successfully from post ID: " + postId, HttpStatus.NO_CONTENT);
    }


}
