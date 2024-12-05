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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CommentRestControllerTest {

    @InjectMocks
    private CommentRestController commentRestController;

    @Mock
    private CommentService commentService;

    @Mock
    private PostService postService;

    @Mock
    private Post post;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private List<Post> generateMockPosts(int numberOfPosts) {
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < numberOfPosts; i++) {
            Post post = new Post();
            post.setId((long) (i + 1));
            post.setTitle("Post Title " + (i + 1));
            post.setContent("Content for post " + (i + 1));
            posts.add(post);
        }
        return posts;
    }

    private List<Comment> generateMockComments(Long postId, int numberOfComments) {
        List<Comment> comments = new ArrayList<>();
        for (int i = 0; i < numberOfComments; i++) {
            Post post = new Post();
            post.setId(postId);
            Comment comment = new Comment("Comment " + (i + 1), post);
            comments.add(comment);
        }
        return comments;
    }

    @Test
    void testGetAllCommentsByPostId() {
        Long postId = 1L;
        List<Comment> comments = generateMockComments(postId, 5);

        when(postService.findById(postId)).thenReturn(new Post());
        when(commentService.findByPostId(postId)).thenReturn(comments);

        ResponseEntity<Object> response = commentRestController.getAllCommentsByPostId(postId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(comments, response.getBody());
        verify(commentService).findByPostId(postId);
    }

    @Test
    void testGetAllCommentsByPostId_NoCommentsFound() {
        Long postId = 1L;

        when(commentService.findByPostId(postId)).thenReturn(new ArrayList<>());

        ResponseEntity<Object> response = commentRestController.getAllCommentsByPostId(postId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("No comments found for post ID " + postId, response.getBody());
    }

    @Test
    void testCreateComment() {
        Long postId = 1L;

        when(post.getId()).thenReturn(postId);

        Comment comment = new Comment("New comment!", post);
        Comment createdComment = new Comment("New comment!", post);

        when(commentService.createComment(postId, comment)).thenReturn(createdComment);

        ResponseEntity<Object> response = commentRestController.createComment(postId, comment);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdComment, response.getBody());
        verify(commentService).createComment(postId, comment);
    }

    @Test
    void testCreateComment_ContentNullOrEmpty() {
        Long postId = 1L;

        Comment commentWithNullContent = new Comment(null, post);
        ResponseEntity<Object> responseNull = commentRestController.createComment(postId, commentWithNullContent);
        assertEquals(HttpStatus.BAD_REQUEST, responseNull.getStatusCode());
        assertEquals("Content cannot be null or empty", responseNull.getBody());

        Comment commentWithEmptyContent = new Comment("", post);
        ResponseEntity<Object> responseEmpty = commentRestController.createComment(postId, commentWithEmptyContent);
        assertEquals(HttpStatus.BAD_REQUEST, responseEmpty.getStatusCode());
        assertEquals("Content cannot be null or empty", responseEmpty.getBody());
    }

    @Test
    void testCreateComment_PostNotFound() {
        Long postId = 1L;
        Comment commentRequest = new Comment("New comment!", post);

        when(commentService.createComment(postId, commentRequest)).thenThrow(new ResourceNotFoundException("Post not found"));

        ResponseEntity<Object> response = commentRestController.createComment(postId, commentRequest);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Post not found with id " + postId, response.getBody());
    }

    @Test
    void testDeleteAllCommentsOfPost() {
        Long postId = 1L;

        when(commentService.deleteAllCommentsByPostId(postId))
                .thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT).hasBody());

        ResponseEntity<Object> response = commentRestController.deleteAllCommentsOfPost(postId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(commentService).deleteAllCommentsByPostId(postId);
    }

    @Test
    void testGetCommentById() {
        Long commentId = 1L;

        when(post.getId()).thenReturn(commentId);

        Comment comment = new Comment("This is a comment", post);

        when(commentService.findById(commentId)).thenReturn(comment);

        ResponseEntity<Object> response = commentRestController.getCommentById(commentId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(comment, response.getBody());
        verify(commentService).findById(commentId);
    }

    @Test
    void testGetCommentById_CommentNotFound() {
        Long commentId = 1L;

        when(commentService.findById(commentId)).thenThrow(new ResourceNotFoundException("Comment not found"));

        ResponseEntity<Object> response = commentRestController.getCommentById(commentId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Comment not found with id " + commentId, response.getBody());
    }

    @Test
    void testUpdateComment() {
        Long commentId = 1L;

        when(post.getId()).thenReturn(commentId);

        Comment commentRequest = new Comment("Updated comment!", post);
        Comment updatedComment = new Comment("Updated comment!", post);

        when(commentService.updateComment(commentId, commentRequest)).thenReturn(updatedComment);

        ResponseEntity<Object> response = commentRestController.updateComment(commentId, commentRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedComment, response.getBody());
        verify(commentService).updateComment(commentId, commentRequest);
    }

    @Test
    void testUpdateComment_ContentNullOrEmpty() {
        long commentId = 1L;

        Comment commentWithNullContent = new Comment();
        commentWithNullContent.setContent(null);
        ResponseEntity<Object> responseNull = commentRestController.updateComment(commentId, commentWithNullContent);
        assertEquals(HttpStatus.BAD_REQUEST, responseNull.getStatusCode());
        assertEquals("Content cannot be null or empty", responseNull.getBody());

        Comment commentWithEmptyContent = new Comment();
        commentWithEmptyContent.setContent("");
        ResponseEntity<Object> responseEmpty = commentRestController.updateComment(commentId, commentWithEmptyContent);
        assertEquals(HttpStatus.BAD_REQUEST, responseEmpty.getStatusCode());
        assertEquals("Content cannot be null or empty", responseEmpty.getBody());
    }

    @Test
    void testUpdateComment_CommentNotFound() {
        Long commentId = 1L;
        Comment commentRequest = new Comment("Updated comment!", post);

        when(commentService.updateComment(commentId, commentRequest)).thenThrow(new ResourceNotFoundException("Comment not found"));

        ResponseEntity<Object> response = commentRestController.updateComment(commentId, commentRequest);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Comment not found with id " + commentId, response.getBody());
    }

    @Test
    void testDeleteComment() {
        Long commentId = 1L;

        when(commentService.deleteComment(commentId)).thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT).hasBody());

        ResponseEntity<Object> response = commentRestController.deleteComment(commentId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(commentService).deleteComment(commentId);
    }

    @Test
    void testDeleteComment_CommentNotFound() {
        Long commentId = 1L;

        when(commentService.deleteComment(commentId)).thenThrow(new ResourceNotFoundException("Comment not found"));

        ResponseEntity<Object> response = commentRestController.deleteComment(commentId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Comment not found with id " + commentId, response.getBody());
    }

    @Test
    void testDeleteAllCommentsOfPost_PostNotFound() {
        Long postId = 1L;

        when(commentService.deleteAllCommentsByPostId(postId)).thenThrow(new ResourceNotFoundException("Post not found"));

        ResponseEntity<Object> response = commentRestController.deleteAllCommentsOfPost(postId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Post not found with id " + postId, response.getBody());
    }
}
