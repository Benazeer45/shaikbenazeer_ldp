package com.springboot.onetomany_bi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@ToString
@Entity
@Getter
@Setter
@Table(name = "post_comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_generator")
	private Long id;

	@Lob
	private String content;

	// Bidirectional relationship (Many-to-one)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "post_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Post post;

	// Custom constructor to initialize content and post
	public Comment(String content, Post post) {
		this.content = content;
		this.post = post;
	}

	// Constructor to initialize ID, content, and post
	public Comment(Long id, String content, Post post) {
		this.id = id;
		this.content = content;
		this.post = post;
	}

	// Default constructor
	public Comment() {
	}

	public Comment(String content) {
		this.content=content;

	}
}
