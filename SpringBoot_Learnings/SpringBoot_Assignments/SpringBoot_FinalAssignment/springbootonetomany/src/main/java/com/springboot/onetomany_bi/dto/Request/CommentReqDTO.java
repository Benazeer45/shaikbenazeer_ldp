package com.springboot.onetomany_bi.dto.Request;

import com.springboot.onetomany_bi.constants.Constants;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentReqDTO {


    @Size(min = 5, max = 50, message = Constants.COMMENT_CONTENT_NULL_OR_EMPTY)
    private String content;

    @NotNull(message = Constants.POST_NOT_FOUND)
    private Long postId;

    @Size(min = 5, max = 20, message = Constants.TITLE_REQUIRED)
    private String title;

    @Size(min = 10, max = 200, message = Constants.DESCRIPTION_REQUIRED)
    private String description;

}
