package com.springboot.onetomany_bi.dto;

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
public class PostResponseDTO {

    private Long id;
    private String title;
    private String description;
    private boolean published;
    private List<CommentResponseDTO> comments;  // Include associated comments in response
    private Date createdAt;  // Date when the post was created
    private Date updatedAt;  // Date when the post was last updated
}
