package com.example.springboot.todo.entity;

import com.example.springboot.todo.constants.Constants;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todo_task")
public class TodoTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = Constants.DESCRIPTION_NOT_BLANK)
    @Size(min = 3, max = 255, message = Constants.DESCRIPTION_SIZE)
    private String description;

    @NotBlank(message = Constants.IS_DONE_NOT_BLANK)
    @Pattern(regexp = "^(done|pending)$", message = Constants.IS_DONE_PATTERN)
    private String isDone;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private TodoGroup group;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
