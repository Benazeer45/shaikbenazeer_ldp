package com.springboot.onetomany_bi.dto.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentResDTO {

    private Long id;
    private String content;
    private Long postId;
    private String title;
    private String description;
}
