package com.example.springboot.todo.controller;

import com.example.springboot.todo.constants.Constants;
import com.example.springboot.todo.dto.Request.TodoTaskRequestDto;
import com.example.springboot.todo.dto.Response.TodoTaskResponseDto;
import com.example.springboot.todo.exception.ResourceNotFoundException;
import com.example.springboot.todo.service.TodoService;
import com.example.springboot.todo.utils.ValidationUtils;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;

@RestController
@RequestMapping(Constants.API_VERSION)
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("")
    public Page<TodoTaskResponseDto> getAllTasks(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        return todoService.getAllTasks(page, size);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Object> getTaskById(@PathVariable("taskId") Long taskId) {
        TodoTaskResponseDto task = todoService.getTaskById(taskId);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> createTask(@Valid @RequestBody TodoTaskRequestDto requestDto) {
        TodoTaskResponseDto createdTask = todoService.createTask(requestDto);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }


    @DeleteMapping("/{taskId}")
    public ResponseEntity<Object> deleteTask(@PathVariable("taskId") Long taskId) {
        String message = todoService.deleteTask(taskId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
