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

    private static final String COMMENT_NOT_FOUND = "Comment not found with id = ";
    private static final String POST_NOT_FOUND = "Post not found with id = ";

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public List<Comment> findByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    @Override
    public Comment findById(Long id) throws ResourceNotFoundException {
        return commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(COMMENT_NOT_FOUND + id));
    }


    @Override
    public Comment createCommentIndependent(Comment commentRequest) {
        return commentRepository.save(commentRequest);
    }

    @Override
    public Comment createComment(Long postId, Comment commentRequest) throws ResourceNotFoundException {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(POST_NOT_FOUND + postId));

        commentRequest.setPost(post);
        return commentRepository.save(commentRequest);
    }

    @Override
    public Comment updateComment(Long id, Comment commentRequest) throws ResourceNotFoundException {
        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(COMMENT_NOT_FOUND + id));
        existingComment.setContent(commentRequest.getContent());
        return commentRepository.save(existingComment);
    }

    @Override
    public boolean deleteComment(Long id) {
        commentRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteAllCommentsByPostId(Long postId) throws ResourceNotFoundException {
        if (!postRepository.existsById(postId)) {
            throw new ResourceNotFoundException(POST_NOT_FOUND + postId);
        }
        commentRepository.deleteByPostId(postId);
        return true;
    }
}
