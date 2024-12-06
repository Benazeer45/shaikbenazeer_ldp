package com.springboot.onetomany_bi.service.impl;

import com.springboot.onetomany_bi.dto.CommentDTO;
import com.springboot.onetomany_bi.entity.Comment;
import com.springboot.onetomany_bi.entity.Post;
import com.springboot.onetomany_bi.exception.ResourceNotFoundException;
import com.springboot.onetomany_bi.repository.CommentRepository;
import com.springboot.onetomany_bi.repository.PostRepository;
import com.springboot.onetomany_bi.service.CommentService;
import com.springboot.onetomany_bi.constants.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CommentDTO> findByPostId(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream()
                .map(comment -> modelMapper.map(comment, CommentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CommentDTO findById(Long id) throws ResourceNotFoundException {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.COMMENT_NOT_FOUND + id));
        return modelMapper.map(comment, CommentDTO.class);
    }

    @Override
    public CommentDTO createComment(Long postId, CommentDTO commentRequest) throws ResourceNotFoundException {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.POST_NOT_FOUND + postId));

        if (!post.isPublished()) {
            throw new ResourceNotFoundException(Constants.POST_NOT_PUBLISHED + postId);
        }

        Comment comment = modelMapper.map(commentRequest, Comment.class);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);

        return modelMapper.map(savedComment, CommentDTO.class);
    }

    @Override
    public CommentDTO updateComment(Long id, CommentDTO commentRequest) throws ResourceNotFoundException {
        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.COMMENT_NOT_FOUND + id));

        existingComment.setContent(commentRequest.getContent());
        Comment updatedComment = commentRepository.save(existingComment);
        return modelMapper.map(updatedComment, CommentDTO.class);
    }

    @Override
    public String deleteComment(Long id) {
        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.COMMENT_NOT_FOUND + id));

        commentRepository.deleteById(id);
        return Constants.COMMENT_DELETED_SUCCESSFULLY;
    }

    @Override
    public String deleteCommentbyId(Long postId, Long commentId) throws ResourceNotFoundException {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.POST_NOT_FOUND + postId));

        Comment comment = commentRepository.findByIdAndPostId(commentId, postId)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.COMMENT_NOT_FOUND + commentId + Constants.POST_NOT_FOUND + postId));

        commentRepository.delete(comment);
        return Constants.COMMENT_DELETED_SUCCESSFULLY;
    }
}
