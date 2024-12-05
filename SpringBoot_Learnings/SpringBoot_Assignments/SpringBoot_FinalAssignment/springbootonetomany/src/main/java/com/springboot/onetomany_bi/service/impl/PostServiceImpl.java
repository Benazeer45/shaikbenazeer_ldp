package com.springboot.onetomany_bi.service.impl;

import com.springboot.onetomany_bi.exception.ResourceNotFoundException;
import com.springboot.onetomany_bi.model.Comment;
import com.springboot.onetomany_bi.model.Post;
import com.springboot.onetomany_bi.repository.PostRepository;
import com.springboot.onetomany_bi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private static final String POST_NOT_FOUND_MESSAGE = "Post not found with id = ";

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> findAll(String title) {
        return (title == null) ? postRepository.findAll() : postRepository.findByTitleContaining(title);
    }

    @Override
    public Post findById(long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(POST_NOT_FOUND_MESSAGE + id));
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(long id, Post updatedPost) {
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(POST_NOT_FOUND_MESSAGE + id));

        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setDescription(updatedPost.getDescription());
        existingPost.setPublished(updatedPost.isPublished());

        return postRepository.save(existingPost);
    }

    @Override
    public void deletePost(long id) {
        if (!postRepository.existsById(id)) {
            throw new ResourceNotFoundException(POST_NOT_FOUND_MESSAGE + id);
        }
        postRepository.deleteById(id);
    }

    @Override
    public void deleteAllPosts() {
        postRepository.deleteAll();
    }

    @Override
    public List<Post> findByPublished(boolean published) {
        return postRepository.findByPublished(published);
    }
}

package com.springboot.onetomany_bi.service.impl;

import com.springboot.onetomany_bi.exception.ResourceNotFoundException;
import com.springboot.onetomany_bi.model.Comment;
import com.springboot.onetomany_bi.model.Post;
import com.springboot.onetomany_bi.repository.CommentRepository;
import com.springboot.onetomany_bi.repository.PostRepository;
import com.springboot.onetomany_bi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private static final String COMMENT_NOT_FOUND_MESSAGE = "Comment not found with id = ";

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public void createComment(Long postId, String content) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + postId));

        Comment comment = new Comment();
        comment.setContent(content);
        comment.setPost(post);

        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        if (!commentRepository.existsById(commentId)) {
            throw new ResourceNotFoundException(COMMENT_NOT_FOUND_MESSAGE + commentId);
        }
        commentRepository.deleteById(commentId);
    }
}
