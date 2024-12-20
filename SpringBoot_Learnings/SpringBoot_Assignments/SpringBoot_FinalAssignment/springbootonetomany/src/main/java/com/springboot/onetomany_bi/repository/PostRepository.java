package com.springboot.onetomany_bi.repository;

import com.springboot.onetomany_bi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {

	// Find posts by their published status
	List<Post> findByPublished(boolean published);

	// Find posts by title containing a keyword
	List<Post> findByTitleContaining(String title);
}
