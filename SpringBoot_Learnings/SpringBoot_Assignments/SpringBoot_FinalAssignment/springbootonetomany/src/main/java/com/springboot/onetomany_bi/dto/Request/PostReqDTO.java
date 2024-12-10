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
public class PostReqDTO {

    @NotBlank
    @Size(min = 4, max = 20, message = Constants.TITLE_REQUIRED)
    private String title;

    @Size(min = 10, max = 200, message = Constants.DESCRIPTION_REQUIRED)
    @NotBlank
    private String description;

    private boolean published;

}
