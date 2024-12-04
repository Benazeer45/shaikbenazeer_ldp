package com.springboot.onetomany_bi.controller;

import com.springboot.onetomany_bi.exception.ResourceNotFoundException;
import com.springboot.onetomany_bi.model.Comment;
import com.springboot.onetomany_bi.model.Post;
import com.springboot.onetomany_bi.service.CommentService;
import com.springboot.onetomany_bi.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

 class PostRestControllerTest {

    @InjectMocks
    private PostRestController postRestController;

    @Mock
    private PostService postService;

    @Mock
    private CommentService commentService;


    @BeforeEach
     void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testGetAllPosts() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("Post 1", "Description 1", true));
        posts.add(new Post("Post 2", "Description 2", false));

        when(postService.findAll(null)).thenReturn(posts);

        ResponseEntity<List<Post>> response = postRestController.getAllPosts(null);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(posts, response.getBody());
        verify(postService).findAll(null);
    }

    @Test
     void testGetPostById() throws ResourceNotFoundException {
        long postId = 1L;
        Post post = new Post("Post 1", "Description 1", true);

        when(postService.findById(postId)).thenReturn(Optional.of(post));

        ResponseEntity<Post> response = postRestController.getPostById(postId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(post, response.getBody());
        verify(postService).findById(postId);
    }

    @Test
     void testGetPostById_PostNotFound() {
        long postId = 1L;

        when(postService.findById(postId)).thenReturn(Optional.empty());

        try {
            postRestController.getPostById(postId);
        } catch (ResourceNotFoundException ex) {
            assertEquals("Post not found with id " + postId, ex.getMessage());
        }

        verify(postService).findById(postId);
    }

    @Test
     void testCreatePost() {
        Post post = new Post("New Post", "Description", true);
        Post createdPost = new Post("New Post", "Description", true);

        when(postService.createPost(post)).thenReturn(createdPost);

        ResponseEntity<Object> response = postRestController.createPost(post);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Post created successfully with ID: " + createdPost.getId(), response.getBody());
        verify(postService).createPost(post);
    }

    @Test
     void testCreatePost_TitleOrDescriptionNull() {
        // Test null title
        Post postWithNullTitle = new Post(null, "Description", true);
        ResponseEntity<Object> responseNullTitle = postRestController.createPost(postWithNullTitle);

        assertEquals(HttpStatus.BAD_REQUEST, responseNullTitle.getStatusCode());
        assertEquals("Title cannot be null or empty", responseNullTitle.getBody());

        // Test null description
        Post postWithNullDescription = new Post("Title", null, true);
        ResponseEntity<Object> responseNullDescription = postRestController.createPost(postWithNullDescription);

        assertEquals(HttpStatus.BAD_REQUEST, responseNullDescription.getStatusCode());
        assertEquals("Description cannot be null or empty", responseNullDescription.getBody());
    }

    @Test
     void testUpdatePost() throws ResourceNotFoundException {
        long postId = 1L;
        Post postRequest = new Post("Updated Post", "Updated Description", true);
        Post updatedPost = new Post("Updated Post", "Updated Description", true);

        when(postService.updatePost(postId, postRequest)).thenReturn(updatedPost);

        ResponseEntity<Object> response = postRestController.updatePost(postId, postRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Post updated successfully with ID: " + updatedPost.getId(), response.getBody());
        verify(postService).updatePost(postId, postRequest);
    }

    @Test
     void testUpdatePost_PostNotFound() {
        long postId = 1L;
        Post postRequest = new Post("Updated Post", "Updated Description", true);

        when(postService.updatePost(postId, postRequest)).thenThrow(new ResourceNotFoundException("Post not found"));

        try {
            postRestController.updatePost(postId, postRequest);
        } catch (ResourceNotFoundException ex) {
            assertEquals("Post not found", ex.getMessage());
        }

        verify(postService).updatePost(postId, postRequest);
    }

    @Test
     void testDeletePost() {
        long postId = 1L;

        doNothing().when(postService).deletePost(postId);

        ResponseEntity<Object> response = postRestController.deletePost(postId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals("Post deleted successfully", response.getBody());
        verify(postService).deletePost(postId);
    }

    @Test
     void testDeleteAllPosts() {
        doNothing().when(postService).deleteAllPosts();

        ResponseEntity<Object> response = postRestController.deleteAllPosts();

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals("All posts deleted successfully", response.getBody());
        verify(postService).deleteAllPosts();
    }

    @Test
     void testFindByPublished() {
        List<Post> publishedPosts = new ArrayList<>();
        publishedPosts.add(new Post( "Post 1", "Description 1", true));

        when(postService.findByPublished(true)).thenReturn(publishedPosts);

        ResponseEntity<List<Post>> response = postRestController.findByPublished();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(publishedPosts, response.getBody());
        verify(postService).findByPublished(true);
    }

    @Test
     void testCreateComment() throws ResourceNotFoundException {
        long postId = 1L;
        Comment commentRequest = new Comment("Great post!");

        Post post = new Post("Post Title", "Post Description", true);
        post.setId(1L);
        post.setComments(new ArrayList<>());

        when(postService.findById(postId)).thenReturn(Optional.of(post));
        when(commentService.createComment(postId, commentRequest)).thenReturn(commentRequest);
        when(postService.updatePost(post.getId(), post)).thenReturn(post);

        ResponseEntity<Object> response = postRestController.createComment(postId, commentRequest);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Comment created successfully for post ID: " + postId, response.getBody());
        verify(postService).findById(postId);
        verify(commentService).createComment(postId, commentRequest);
        verify(postService).updatePost(post.getId(), post);
    }



    @Test
     void testCreateComment_ContentNull() {
        long postId = 1L;
        Comment commentRequest = new Comment(null);

        ResponseEntity<Object> response = postRestController.createComment(postId, commentRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Content cannot be null or empty", response.getBody());
    }

    @Test
     void testCreateComment_ContentEmpty() {
        long postId = 1L;
        Comment commentRequest = new Comment("");

        ResponseEntity<Object> response = postRestController.createComment(postId, commentRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Content cannot be null or empty", response.getBody());
    }

    @Test
     void testCreateComment_PostNotFound() throws ResourceNotFoundException {
        long postId = 1L;
        Comment commentRequest = new Comment("Great post!");

        when(postService.findById(postId)).thenReturn(Optional.empty());

        try {
            postRestController.createComment(postId, commentRequest);
        } catch (ResourceNotFoundException ex) {
            assertEquals("Post not found with id " + postId, ex.getMessage());
        }

        verify(postService).findById(postId);
    }


    @Test
     void testDeleteComment() throws ResourceNotFoundException {
        long postId = 1L;
        long commentId = 2L;
        Post post = new Post("Post Title", "Post Description", true);
        post.setId(postId);
        post.setComments(new ArrayList<>());
        Comment comment = new Comment("Great comment!");

        post.getComments().add(comment);

        when(postService.findById(postId)).thenReturn(Optional.of(post));
        when(commentService.findById(commentId)).thenReturn(comment);

        when(postService.updatePost(post.getId(), post)).thenReturn(post);

        ResponseEntity<Object> response = postRestController.deleteComment(postId, commentId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals("Comment deleted successfully from post ID: " + postId, response.getBody());

        verify(postService).findById(postId);
        verify(commentService).findById(commentId);
        verify(postService).updatePost(post.getId(), post);
        verify(commentService).deleteComment(commentId);
    }

    @Test
     void testDeleteComment_PostNotFound() throws ResourceNotFoundException {
        long postId = 1L;
        long commentId = 2L;

        when(postService.findById(postId)).thenReturn(Optional.empty());

        try {
            postRestController.deleteComment(postId, commentId);
            fail("Expected ResourceNotFoundException to be thrown");
        } catch (ResourceNotFoundException ex) {
            assertEquals("Post not found with id " + postId, ex.getMessage());
        }

        verify(postService).findById(postId);
    }


    @Test
     void testDeleteComment_CommentNotFound() throws ResourceNotFoundException {
        long postId = 1L;
        long commentId = 2L;
        Post post = new Post("Post Title", "Post Description", true);

        when(postService.findById(postId)).thenReturn(Optional.of(post));
        when(commentService.findById(commentId)).thenReturn(null);

        try {
            postRestController.deleteComment(postId, commentId);
            fail("Expected ResourceNotFoundException to be thrown");
        } catch (ResourceNotFoundException ex) {
            assertEquals("Cannot read the comment", ex.getMessage());
        }

        verify(postService).findById(postId);
    }

    @Test
    void testCreatePost_TitleNull() {
        Post post = new Post(null, "Valid description", true);

        ResponseEntity<Object> response = postRestController.createPost(post);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Title cannot be null or empty", response.getBody());
    }

    @Test
     void testCreatePost_TitleEmpty() {
        Post post = new Post("", "Valid description", true);

        ResponseEntity<Object> response = postRestController.createPost(post);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Title cannot be null or empty", response.getBody());
    }

    @Test
     void testCreatePost_DescriptionNull() {
        Post post = new Post("Valid title", null, true);

        ResponseEntity<Object> response = postRestController.createPost(post);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Description cannot be null or empty", response.getBody());
    }

    @Test
    void testCreatePost_DescriptionEmpty() {
        Post post = new Post("Valid title", "", true);

        ResponseEntity<Object> response = postRestController.createPost(post);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Description cannot be null or empty", response.getBody());
    }

}