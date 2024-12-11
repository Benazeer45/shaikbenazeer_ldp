package com.example.springboot.todo.service;

import com.example.springboot.todo.dto.Request.TodoTaskRequestDto;
import com.example.springboot.todo.dto.Response.TodoTaskResponseDto;
import com.example.springboot.todo.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;

public interface TodoService {

    Page<TodoTaskResponseDto> getAllTasks(int page, int size);

    TodoTaskResponseDto createTask(TodoTaskRequestDto requestDto);

    String deleteTask(Long taskId) throws ResourceNotFoundException;

    TodoTaskResponseDto getTaskById(Long taskId);
}
