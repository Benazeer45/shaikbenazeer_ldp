package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Bi_Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "instructor_id")
    private Bi_Instructor instructor;

    public Bi_Course() {
    }

    public Bi_Course(String title) {
        this.title = title;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Bi_Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Bi_Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor=" + (instructor != null ? instructor.getId() : "null") +
                '}';
    }
}
