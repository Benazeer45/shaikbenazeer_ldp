package com.springboot.onetomany_bi.service;

import com.springboot.onetomany_bi.dto.PostDTO;
import com.springboot.onetomany_bi.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

	Page<PostDTO> findAll(int page, int size, Boolean published, String title) throws ResourceNotFoundException;

	PostDTO findById(Long id);

	String createPost(PostDTO postDTO);

	PostDTO updatePost(Long id, PostDTO postDTO) throws ResourceNotFoundException;

	String deletePost(Long id) throws ResourceNotFoundException;

}
