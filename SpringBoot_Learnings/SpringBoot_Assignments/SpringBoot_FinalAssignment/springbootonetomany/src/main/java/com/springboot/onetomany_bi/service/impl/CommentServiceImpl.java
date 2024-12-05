package com.springboot.onetomany_bi.service.impl;

import com.springboot.onetomany_bi.exception.ResourceNotFoundException;
import com.springboot.onetomany_bi.model.Comment;
import com.springboot.onetomany_bi.model.Post;
import com.springboot.onetomany_bi.repository.CommentRepository;
import com.springboot.onetomany_bi.repository.PostRepository;
import com.springboot.onetomany_bi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    private static final String COMMENT_NOT_FOUND = "Comment not found with id = %d";
    private static final String POST_NOT_FOUND = "Post not found with id = %d";

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public List<Comment> findByPostId(Long postId) {
        if (!postRepository.existsById(postId)) {
            throw new ResourceNotFoundException(String.format(POST_NOT_FOUND, postId));
        }
        return commentRepository.findByPostId(postId);
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(COMMENT_NOT_FOUND, id)));
    }

    @Override
    public Comment createCommentIndependent(Comment commentRequest) {
        return commentRepository.save(commentRequest);
    }

    @Override
    public Comment createComment(Long postId, Comment commentRequest) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(POST_NOT_FOUND, postId)));

        commentRequest.setPost(post);
        return commentRepository.save(commentRequest);
    }

    @Override
    public Comment updateComment(Long id, Comment commentRequest) {
        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(COMMENT_NOT_FOUND, id)));

        existingComment.setContent(commentRequest.getContent());
        return commentRepository.save(existingComment);
    }

    @Override
    public boolean deleteComment(Long id) {
        if (!commentRepository.existsById(id)) {
            throw new ResourceNotFoundException(String.format(COMMENT_NOT_FOUND, id));
        }
        commentRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteAllCommentsByPostId(Long postId) {
        if (!postRepository.existsById(postId)) {
            throw new ResourceNotFoundException(String.format(POST_NOT_FOUND, postId));
        }
        commentRepository.deleteByPostId(postId);
        return true;
    }
}
