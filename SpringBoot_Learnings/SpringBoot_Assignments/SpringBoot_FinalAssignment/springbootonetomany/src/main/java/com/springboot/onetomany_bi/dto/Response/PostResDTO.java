package com.springboot.onetomany_bi.dto.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostResDTO {

    private Long id;
    private String title;
    private String description;
    private boolean published;
    private List<CommentResDTO> comments;  // Include associated comments in response
}
