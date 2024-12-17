package com.example.springboot.todo.service.Impl;

import com.example.springboot.todo.dto.Request.TodoTaskRequestDto;
import com.example.springboot.todo.dto.Response.TodoTaskResponseDto;
import com.example.springboot.todo.entity.TodoGroup;
import com.example.springboot.todo.entity.TodoTask;
import com.example.springboot.todo.exception.ResourceNotFoundException;
import com.example.springboot.todo.repository.TodoGroupRepository;
import com.example.springboot.todo.repository.TodoTaskRepository;
import com.example.springboot.todo.service.TodoService;
import com.example.springboot.todo.constants.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoGroupRepository groupRepository;
    private final TodoTaskRepository taskRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TodoServiceImpl(TodoGroupRepository groupRepository, TodoTaskRepository taskRepository, ModelMapper modelMapper) {
        this.groupRepository = groupRepository;
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<TodoTaskResponseDto> getAllTasks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TodoTask> taskPage = taskRepository.findAll(pageable);
        return taskPage.map(task -> modelMapper.map(task, TodoTaskResponseDto.class));
    }

    @Override
    public TodoTaskResponseDto getTaskById(Long taskId) {
        Optional<TodoTaskResponseDto> task = taskRepository.findById(taskId)
                .map(todo -> new TodoTaskResponseDto(todo.getId(), todo.getDescription(), todo.getIsDone()));

        if (task.isEmpty()) {
            throw new ResourceNotFoundException(Constants.TASK_NOT_FOUND_BY_ID + taskId + Constants.TASK_NOT_FOUND_SUFFIX);
        }

        return task.get();
    }

    @Override
    public TodoTaskResponseDto createTask(TodoTaskRequestDto requestDto) {
        TodoGroup group = groupRepository.findById(requestDto.getGroupId())
                .orElseThrow(() -> new ResourceNotFoundException(Constants.GROUP_NOT_FOUND + requestDto.getGroupId()));

        TodoTask task = modelMapper.map(requestDto, TodoTask.class);
        task.setGroup(group);

        TodoTask savedTask = taskRepository.save(task);
        return modelMapper.map(savedTask, TodoTaskResponseDto.class);
    }

    @Override
    public String deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
        return Constants.TASK_DELETED_SUCCESS;
    }
}
