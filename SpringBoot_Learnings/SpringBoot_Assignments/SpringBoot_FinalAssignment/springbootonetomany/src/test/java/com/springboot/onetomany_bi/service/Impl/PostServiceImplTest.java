package com.springboot.onetomany_bi.service.impl;

import com.springboot.onetomany_bi.exception.ResourceNotFoundException;
import com.springboot.onetomany_bi.model.Post;
import com.springboot.onetomany_bi.repository.PostRepository;
import com.springboot.onetomany_bi.service.impl.PostServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

 class PostServiceImplTest {

    @InjectMocks
    private PostServiceImpl postService;

    @Mock
    private PostRepository postRepository;

    @BeforeEach
     void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testFindAll() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("Post 1", "Description 1", true));
        posts.add(new Post("Post 2", "Description 2", false));

        when(postRepository.findAll()).thenReturn(posts);

        List<Post> result = postService.findAll(null);

        assertEquals(2, result.size());
        assertEquals(posts, result);
        verify(postRepository).findAll();
    }

    @Test
     void testFindById_Success() throws ResourceNotFoundException {
        long postId = 1L;
        Post post = new Post("Post 1", "Description 1", true);

        when(postRepository.findById(postId)).thenReturn(Optional.of(post));

        Post result = postService.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found"));

        assertEquals(post, result);
        verify(postRepository).findById(postId);
    }

    @Test
     void testFindById_PostNotFound() {
        long postId = 1L;

        when(postRepository.findById(postId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            postService.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        });

        verify(postRepository).findById(postId);
    }

    @Test
     void testCreatePost() {
        Post post = new Post("New Post", "Description", true);

        when(postRepository.save(post)).thenReturn(post);

        Post result = postService.createPost(post);

        assertEquals(post, result);
        verify(postRepository).save(post);
    }

    @Test
     void testUpdatePost_Success() throws ResourceNotFoundException {
        long postId = 1L;
        Post existingPost = new Post("Old Post", "Old Description", true);
        Post updatedPost = new Post("Updated Post", "Updated Description", true);

        when(postRepository.findById(postId)).thenReturn(Optional.of(existingPost));
        when(postRepository.save(existingPost)).thenReturn(updatedPost);

        Post result = postService.updatePost(postId, updatedPost);

        assertEquals(updatedPost.getTitle(), result.getTitle());
        assertEquals(updatedPost.getDescription(), result.getDescription());
        verify(postRepository).findById(postId);
        verify(postRepository).save(existingPost);
    }

    @Test
     void testUpdatePost_PostNotFound() {
        long postId = 1L;
        Post updatedPost = new Post("Updated Post", "Updated Description", true);

        when(postRepository.findById(postId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            postService.updatePost(postId, updatedPost);
        });

        verify(postRepository).findById(postId);
    }

    @Test
     void testDeletePost_Success() {
        long postId = 1L;

        when(postRepository.existsById(postId)).thenReturn(true);
        doNothing().when(postRepository).deleteById(postId);

        postService.deletePost(postId);

        verify(postRepository).existsById(postId);
        verify(postRepository).deleteById(postId);
    }

    @Test
     void testDeletePost_PostNotFound() {
        long postId = 1L;

        when(postRepository.existsById(postId)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> {
            postService.deletePost(postId);
        });

        verify(postRepository).existsById(postId);
    }

    @Test
    void testDeleteAllPosts() {
        doNothing().when(postRepository).deleteAll();

        postService.deleteAllPosts();

        verify(postRepository).deleteAll();
    }

    @Test
    void testFindByPublished() {
        List<Post> publishedPosts = new ArrayList<>();
        publishedPosts.add(new Post("Published Post", "Description", true));

        when(postRepository.findByPublished(true)).thenReturn(publishedPosts);

        List<Post> result = postService.findByPublished(true);

        assertEquals(1, result.size());
        assertEquals(publishedPosts, result);
        verify(postRepository).findByPublished(true);
    }

    @Test
    void estFindAll_WithNullTitle() {
        // Prepare test data
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("Post 1", "Description 1", true));
        posts.add(new Post("Post 2", "Description 2", false));

        // Mock the repository call for findAll when title is null
        when(postRepository.findAll()).thenReturn(posts);

        // Call the method being tested with a null title
        List<Post> result = postService.findAll(null);

        // Verify that the correct result is returned and the repository method is called
        assertEquals(2, result.size());
        assertEquals(posts, result);
        verify(postRepository).findAll();
    }

    @Test
    void testFindAll_WithTitle() {
        String title = "Post";
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("Post 1", "Description 1", true));
        posts.add(new Post("Post 2", "Description 2", false));

        when(postRepository.findByTitleContaining(title)).thenReturn(posts);

        List<Post> result = postService.findAll(title);

        assertEquals(2, result.size());
        assertEquals(posts, result);
        verify(postRepository).findByTitleContaining(title);
    }

}
