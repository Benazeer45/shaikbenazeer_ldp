package com.springboot.onetomany_bi.service.Impl;

import com.springboot.onetomany_bi.exception.ResourceNotFoundException;
import com.springboot.onetomany_bi.model.Comment;
import com.springboot.onetomany_bi.model.Post;
import com.springboot.onetomany_bi.repository.CommentRepository;
import com.springboot.onetomany_bi.repository.PostRepository;
import com.springboot.onetomany_bi.service.impl.CommentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CommentServiceImplTest {
    @Mock
    private CommentRepository commentRepository;

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private CommentServiceImpl commentService;

    private Comment comment;
    private Post post;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        post = new Post("Post Title", "Post Description", true);
        post.setId(1L);

        comment = new Comment("Comment content");
        comment.setId(1L);
        comment.setPost(post);
    }

    @Test
    void testFindByPostId() {
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        when(commentRepository.findByPostId(1L)).thenReturn(comments);

        List<Comment> result = commentService.findByPostId(1L);

        assertEquals(1, result.size(), "Expected exactly 1 comment for post ID 1.");
        assertEquals(comment.getContent(), result.get(0).getContent(), "Content does not match.");
        verify(commentRepository).findByPostId(1L);
    }

    @Test
    void testFindById_CommentFound() throws ResourceNotFoundException {
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));

        Comment result = commentService.findById(1L);

        assertNotNull(result, "Comment should not be null.");
        assertEquals(1L, result.getId(), "Comment ID does not match.");
        verify(commentRepository).findById(1L);
    }

    @Test
    void testFindById_CommentNotFound() {
        when(commentRepository.findById(1L)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class,
                () -> commentService.findById(1L), "Expected ResourceNotFoundException for missing comment.");
        assertEquals("Comment not found with id = 1", exception.getMessage());
        verify(commentRepository).findById(1L);
    }

    @Test
    void testCreateCommentIndependent() {
        when(commentRepository.save(comment)).thenReturn(comment);

        Comment createdComment = commentService.createCommentIndependent(comment);

        assertNotNull(createdComment, "Created comment should not be null.");
        assertEquals("Comment content", createdComment.getContent(), "Comment content does not match.");
        verify(commentRepository).save(comment);
    }

    @Test
    void testCreateComment() throws ResourceNotFoundException {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(commentRepository.save(comment)).thenReturn(comment);

        Comment createdComment = commentService.createComment(1L, comment);

        assertNotNull(createdComment, "Created comment should not be null.");
        assertEquals("Comment content", createdComment.getContent(), "Comment content does not match.");
        assertEquals(1L, createdComment.getPost().getId(), "Post ID does not match.");
        verify(postRepository).findById(1L);
        verify(commentRepository).save(comment);
    }

    @Test
    void testCreateComment_PostNotFound() {
        when(postRepository.findById(1L)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class,
                () -> commentService.createComment(1L, comment), "Expected ResourceNotFoundException for missing post.");
        assertEquals("Post not found with id = 1", exception.getMessage());
        verify(postRepository).findById(1L);
    }

    @Test
    void testUpdateComment() throws ResourceNotFoundException {
        Comment updatedComment = new Comment("Updated content");
        updatedComment.setId(1L);

        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));
        when(commentRepository.save(any(Comment.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Comment result = commentService.updateComment(1L, updatedComment);

        assertNotNull(result, "Updated comment should not be null.");
        assertEquals("Updated content", result.getContent(), "Content does not match.");
        verify(commentRepository).findById(1L);
        verify(commentRepository).save(any(Comment.class));
    }

    @Test
    void testUpdateComment_CommentNotFound() {
        Comment updatedComment = new Comment("Updated content");
        updatedComment.setId(1L);

        when(commentRepository.findById(1L)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class,
                () -> commentService.updateComment(1L, updatedComment), "Expected ResourceNotFoundException for missing comment.");
        assertEquals("Comment not found with id = 1", exception.getMessage());
        verify(commentRepository).findById(1L);
    }

    @Test
    void testDeleteComment() {
        doNothing().when(commentRepository).deleteById(1L);

        boolean result = commentService.deleteComment(1L);

        assertTrue(result, "Expected deletion to return true.");
        verify(commentRepository).deleteById(1L);
    }

    @Test
    void testDeleteAllCommentsByPostId() throws ResourceNotFoundException {
        when(postRepository.existsById(1L)).thenReturn(true);
        doNothing().when(commentRepository).deleteByPostId(1L);

        boolean result = commentService.deleteAllCommentsByPostId(1L);

        assertTrue(result, "Expected deletion of all comments to return true.");
        verify(postRepository).existsById(1L);
        verify(commentRepository).deleteByPostId(1L);
    }

    @Test
    void testDeleteAllCommentsByPostId_PostNotFound() {
        when(postRepository.existsById(1L)).thenReturn(false);

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class,
                () -> commentService.deleteAllCommentsByPostId(1L), "Expected ResourceNotFoundException for missing post.");
        assertEquals("Post not found with id = 1", exception.getMessage());
        verify(postRepository).existsById(1L);
    }
}
