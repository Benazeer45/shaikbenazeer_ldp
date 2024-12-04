package com.springboot.onetomany_bi.service.impl;

import com.springboot.onetomany_bi.exception.ResourceNotFoundException;
import com.springboot.onetomany_bi.model.Post;
import com.springboot.onetomany_bi.repository.PostRepository;
import com.springboot.onetomany_bi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

	private static final String POST_NOT_FOUND_MESSAGE = "Post not found with id = ";

	private final PostRepository postRepository;

	@Autowired
	public PostServiceImpl(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public List<Post> findAll(String title) {
		return (title == null) ? postRepository.findAll() : postRepository.findByTitleContaining(title);
	}

	@Override
	public Optional<Post> findById(long id) throws ResourceNotFoundException {
		return Optional.ofNullable(postRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(POST_NOT_FOUND_MESSAGE + id)));
	}

	@Override
	public Post createPost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public Post updatePost(long id, Post updatedPost) throws ResourceNotFoundException {
		Post existingPost = postRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(POST_NOT_FOUND_MESSAGE + id));

		existingPost.setTitle(updatedPost.getTitle());
		existingPost.setDescription(updatedPost.getDescription());
		existingPost.setPublished(updatedPost.isPublished());

		return postRepository.save(existingPost);
	}

	@Override
	public void deletePost(long id) {
		if (!postRepository.existsById(id)) {
			throw new ResourceNotFoundException(POST_NOT_FOUND_MESSAGE + id);
		}
		postRepository.deleteById(id);
	}

	@Override
	public void deleteAllPosts() {
		postRepository.deleteAll();
	}

	@Override
	public List<Post> findByPublished(boolean published) {
		return postRepository.findByPublished(published);
	}
}
