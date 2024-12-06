package com.springboot.onetomany_bi.dto;

import com.springboot.onetomany_bi.constants.Constants;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

    private Long id;

    @Size(min = 5, max = 20, message = Constants.TITLE_REQUIRED)
    private String title;

    @Size(min = 10, max = 200, message = Constants.DESCRIPTION_REQUIRED)
    private String description;

    @NotNull(message = Constants.PUBLISHED_NOT_FOUND)
    private boolean published;

    private List<CommentDTO> comments;  // Include associated comments

    private Date createdAt;  // Date when the post was created
    private Date updatedAt;  // Date when the post was last updated
}
