package com.example.springboot.todo.repository;

import com.example.springboot.todo.entity.TodoGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoGroupRepository extends JpaRepository<TodoGroup, Long> {}
