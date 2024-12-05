package com.springboot.onetomany_bi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ToString
@Entity
@Getter
@Setter
@Table(name = "post_comments")
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_generator")
    private Long id;

    @Lob
    @NotBlank(message = "Content cannot be null or empty")
    @Size(max = 1000, message = "Content cannot exceed 1000 characters")
    private String content;

    // Bidirectional relationship (Many-to-one)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Post post;

    // Constructor to initialize content and post
    public Comment(String content, Post post) {
        this.content = content;
        this.post = post;
    }
}
