package com.springboot.onetomany_bi.service;

import com.springboot.onetomany_bi.dto.Request.PostReqDTO;
import com.springboot.onetomany_bi.dto.Response.PostResDTO;
import com.springboot.onetomany_bi.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

	Page<PostResDTO> findAll(int page, int size, Boolean published, String title) throws ResourceNotFoundException;

	PostResDTO findById(Long id);

	PostResDTO createPost(PostReqDTO postDTO);

	PostResDTO updatePost(Long id, PostReqDTO postDTO) throws ResourceNotFoundException;

	String deletePost(Long id) throws ResourceNotFoundException;

}
