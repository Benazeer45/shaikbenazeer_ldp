package com.springboot.onetomany_bi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_generator")
	private Long id;

	@NotBlank(message = "Title cannot be blank")
	@Size(max = 100, message = "Title should not exceed 100 characters")
	@Column(name = "title")
	private String title;

	@NotBlank(message = "Description cannot be blank")
	@Size(max = 500, message = "Description should not exceed 500 characters")
	@Column(name = "description")
	private String description;

	@Column(name = "published")
	private boolean published;

	// Bidirectional relationship (One-to-many)
	@OneToMany(mappedBy = "post", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Comment> comments;

	public Post(String title, String description, boolean published) {
		this.title = title;
		this.description = description;
		this.published = published;
	}
}
