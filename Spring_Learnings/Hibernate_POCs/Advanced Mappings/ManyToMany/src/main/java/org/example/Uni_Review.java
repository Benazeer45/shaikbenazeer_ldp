package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Uni_Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "comment")
    private String comment;

    // Constructors
    public Uni_Review() {
    }

    public Uni_Review(String comment) {
        this.comment = comment;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Uni_Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
