package com.springboot.onetomany_bi.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

    private Long id;

    @NotEmpty(message = "Content cannot be empty")
    @Size(min = 5, max = 500, message = "Content must be between 5 and 500 characters")
    private String content;

    @NotNull(message = "Post ID cannot be null")
    private Long postId;

    @NotEmpty(message = "Title cannot be empty")
    @Size(max = 100, message = "Title cannot exceed 100 characters")
    private String title;

    @NotEmpty(message = "Description cannot be empty")
    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    private String description;
}
