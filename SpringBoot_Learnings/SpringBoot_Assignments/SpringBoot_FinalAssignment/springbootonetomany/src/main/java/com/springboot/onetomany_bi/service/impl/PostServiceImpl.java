package com.springboot.onetomany_bi.service.impl;

import com.springboot.onetomany_bi.dto.Request.PostReqDTO;
import com.springboot.onetomany_bi.dto.Response.PostResDTO;
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

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Page<PostResDTO> findAll(int page, int size, Boolean published, String title) throws ResourceNotFoundException {
		Pageable pageable = PageRequest.of(page, size);

		Specification<Post> spec = Specification.where(PostSpecifications.isPublished(published))
				.and(PostSpecifications.hasTitleContaining(title));

		Page<Post> postPage = postRepository.findAll(spec, pageable);

		return postPage.map(post -> modelMapper.map(post, PostResDTO.class));
	}

	@Override
	public PostResDTO findById(Long id) {
		Post post = postRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(Constants.POST_NOT_FOUND + id));
		return modelMapper.map(post, PostResDTO.class);
	}

	@Override
	public PostResDTO createPost(PostReqDTO postDTO) {
		Post post = modelMapper.map(postDTO, Post.class);

		Post savedPost = postRepository.save(post);
		return modelMapper.map(savedPost, PostResDTO.class);
	}


	@Override
	public PostResDTO updatePost(Long id, PostReqDTO postDTO) {
		Post existingPost = postRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(Constants.POST_NOT_FOUND + id));

		existingPost.setTitle(postDTO.getTitle());
		existingPost.setDescription(postDTO.getDescription());
		existingPost.setPublished(postDTO.isPublished());

		Post updatedPost = postRepository.save(existingPost);
		return modelMapper.map(updatedPost, PostResDTO.class);
	}

	@Override
	public String deletePost(Long id) {
		Post existingPost = postRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(Constants.POST_NOT_FOUND + id));

		postRepository.deleteById(id);
		return Constants.POST_DELETED_SUCCESSFULLY;
	}
}
