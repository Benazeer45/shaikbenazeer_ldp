package com.springboot.onetomany_bi.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDTO {

    private Long id;
    private String content;
    private Long postId;
    private String title;
    private String description;
    private Date createdAt;  // Date when the comment was created
    private Date updatedAt;  // Date when the comment was last updated
}
