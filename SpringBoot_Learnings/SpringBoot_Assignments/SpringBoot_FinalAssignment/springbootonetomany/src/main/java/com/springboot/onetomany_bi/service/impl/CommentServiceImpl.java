package com.springboot.onetomany_bi.service.impl;

import com.springboot.onetomany_bi.dto.Request.CommentReqDTO;
import com.springboot.onetomany_bi.dto.Response.CommentResDTO;
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

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CommentResDTO> findByPostId(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream()
                .map(comment -> modelMapper.map(comment, CommentResDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CommentResDTO findById(Long id) throws ResourceNotFoundException {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.COMMENT_NOT_FOUND + id));
        return modelMapper.map(comment, CommentResDTO.class);
    }

    @Override
    public CommentResDTO createComment(Long postId, CommentReqDTO commentRequest) throws ResourceNotFoundException {
        if (commentRequest.getContent() == null || commentRequest.getContent().isEmpty()) {
            throw new ResourceNotFoundException.ContentMissingException(Constants.COMMENT_CONTENT_NULL_OR_EMPTY);
        }
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.POST_NOT_FOUND + postId));

        if (!post.isPublished()) {
            throw new ResourceNotFoundException(Constants.POST_NOT_PUBLISHED + postId);
        }

        Comment comment = modelMapper.map(commentRequest, Comment.class);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);

        return modelMapper.map(savedComment, CommentResDTO.class);
    }

    @Override
    public CommentResDTO updateComment(Long id, CommentReqDTO commentRequest) throws ResourceNotFoundException {
        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.COMMENT_NOT_FOUND + id));

        if (commentRequest.getContent() == null || commentRequest.getContent().isEmpty()) {
            throw new ResourceNotFoundException.ContentMissingException(Constants.COMMENT_CONTENT_NULL_OR_EMPTY);
        }

        existingComment.setContent(commentRequest.getContent());
        Comment updatedComment = commentRepository.save(existingComment);
        return modelMapper.map(updatedComment, CommentResDTO.class);
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

        Comment comment = (Comment) commentRepository.findByIdAndPostId(commentId, postId)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.COMMENT_NOT_FOUND + commentId + Constants.POST_NOT_FOUND + postId));

        commentRepository.delete(comment);
        return Constants.COMMENT_DELETED_SUCCESSFULLY;
    }
}
