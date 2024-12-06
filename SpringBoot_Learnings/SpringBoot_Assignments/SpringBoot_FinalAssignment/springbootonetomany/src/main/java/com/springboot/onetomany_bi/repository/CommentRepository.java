package com.springboot.onetomany_bi.repository;

import com.springboot.onetomany_bi.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
  List<Comment> findByPostId(Long postId);
  void deleteByPostId(Long postId);

  Optional<Object> findByIdAndPostId(Long commentId, Long postId);
}

