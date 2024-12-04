package com.springboot.onetomany_bi.repository;

import com.springboot.onetomany_bi.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findByPublished(boolean published);

	List<Post> findByTitleContaining(String title);
}
