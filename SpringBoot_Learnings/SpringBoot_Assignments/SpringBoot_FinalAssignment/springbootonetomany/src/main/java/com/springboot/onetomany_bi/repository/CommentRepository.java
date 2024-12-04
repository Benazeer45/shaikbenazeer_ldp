package com.springboot.onetomany_bi.repository;

import com.springboot.onetomany_bi.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
  List<Comment> findByPostId(Long postId);
  void deleteByPostId(Long postId);
}

