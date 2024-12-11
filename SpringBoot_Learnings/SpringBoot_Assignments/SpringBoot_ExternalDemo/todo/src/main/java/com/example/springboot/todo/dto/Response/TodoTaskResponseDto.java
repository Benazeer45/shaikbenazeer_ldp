package com.example.springboot.todo.dto.Response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoTaskResponseDto {
    private Long id;
    private String description;
    private String isDone;

}
