package com.springboot.onetomany_bi.service;

import com.springboot.onetomany_bi.exception.ResourceNotFoundException;
import com.springboot.onetomany_bi.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

	List<Post> findAll(String title);

	Optional<Post> findById(long id) throws ResourceNotFoundException;

	Post createPost(Post post);

	Post updatePost(long id, Post postRequest) throws ResourceNotFoundException;

	void deletePost(long id);

	void deleteAllPosts();

	List<Post> findByPublished(boolean published);
}
