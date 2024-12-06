package com.springboot.onetomany_bi.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_generator")
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "published")
	private boolean published;

	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	// Bidirectional relationship (One-to-many)
	@OneToMany(mappedBy = "post", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Comment> comments;

	public Post(String title, String description, boolean published) {
		this.title = title;
		this.description = description;
		this.published = published;
	}
}
