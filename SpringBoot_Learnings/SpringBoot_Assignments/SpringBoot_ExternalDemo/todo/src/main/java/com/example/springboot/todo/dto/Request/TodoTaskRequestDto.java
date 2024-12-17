package com.example.springboot.todo.dto.Request;

import com.example.springboot.todo.constants.Constants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoTaskRequestDto {

    @NotBlank(message = Constants.DESCRIPTION_NOT_BLANK)
    @Size(min = 3, max = 255, message = Constants.DESCRIPTION_SIZE)
    private String description;

    @NotNull(message = Constants.GROUP_ID_NOT_NULL)
    private Long groupId;

    @NotBlank(message = Constants.IS_DONE_NOT_BLANK)
    @Pattern(regexp = "^(done|pending)$", message = Constants.IS_DONE_PATTERN)
    private String isDone;
}
