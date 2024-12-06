package com.springboot.onetomany_bi.service.impl;

import com.springboot.onetomany_bi.dto.PostDTO;
import com.springboot.onetomany_bi.entity.Post;
import com.springboot.onetomany_bi.exception.ResourceNotFoundException;
import com.springboot.onetomany_bi.repository.PostRepository;
import com.springboot.onetomany_bi.service.PostService;
import com.springboot.onetomany_bi.constants.Constants;
import com.springboot.onetomany_bi.specifications.PostSpecifications;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<PostDTO> findAll(int page, int size, Boolean published, String title) throws ResourceNotFoundException {
        Pageable pageable = PageRequest.of(page, size);
        Specification<Post> spec = Specification.where(PostSpecifications.isPublished(published))
                .and(PostSpecifications.hasTitleContaining(title));

        Page<Post> postPage = postRepository.findAll(spec, pageable);
        return postPage.map(post -> modelMapper.map(post, PostDTO.class));
    }

    @Override
    public PostDTO findById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.POST_NOT_FOUND + id));
        return modelMapper.map(post, PostDTO.class);
    }

    @Override
    public String createPost(PostDTO postDTO) {
        Post post = modelMapper.map(postDTO, Post.class);
        postRepository.save(post);
        return Constants.POST_CREATED_SUCCESSFULLY;
    }

    @Override
    public PostDTO updatePost(Long id, PostDTO postDTO) {
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.POST_NOT_FOUND + id));

        existingPost.setTitle(postDTO.getTitle());
        existingPost.setDescription(postDTO.getDescription());
        existingPost.setPublished(postDTO.isPublished());

        Post updatedPost = postRepository.save(existingPost);
        return modelMapper.map(updatedPost, PostDTO.class);
    }

    @Override
    public String deletePost(Long id) {
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.POST_NOT_FOUND + id));

        postRepository.deleteById(id);
        return Constants.POST_DELETED_SUCCESSFULLY;
    }
}
