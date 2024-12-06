package com.springboot.onetomany_bi.service;

import com.springboot.onetomany_bi.dto.PostDTO;
import com.springboot.onetomany_bi.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService {

	List<PostDTO> findAll() throws ResourceNotFoundException;

	PostDTO findById(Long id);

	String createPost(PostDTO postDTO);

	PostDTO updatePost(Long id, PostDTO postDTO) throws ResourceNotFoundException;

	String deletePost(Long id) throws ResourceNotFoundException;

	List<PostDTO> findByPublished(boolean published);

	Page<PostDTO> findAllPaginated(int page, int size);

	List<PostDTO> findFilteredPosts(Boolean published, String title);
}
