package org.example;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Uni_Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "instructor_id")
    private Uni_Instructor instructor;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Uni_Review> uniReviews = new ArrayList<>();  // Initialize here

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Uni_Student> students = new ArrayList<>();  // Initialize here

    // Constructors
    public Uni_Course() {
    }

    public Uni_Course(String title) {
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

    public Uni_Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Uni_Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Uni_Review> getReviews() {
        return uniReviews;
    }

    public void setReviews(List<Uni_Review> uniReviews) {
        this.uniReviews = uniReviews;
    }

    public List<Uni_Student> getStudents() {
        return students;
    }

    public void setStudents(List<Uni_Student> students) {
        this.students = students;
    }

    // Convenience method to add a review
    public void addReview(Uni_Review uniReview) {
        if (!uniReviews.contains(uniReview)) {
            uniReviews.add(uniReview);
        }
    }

    // Convenience method to add a student
    public void addStudent(Uni_Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    @Override
    public String toString() {
        return "Uni_Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor=" + (instructor != null ? instructor.getId() : "null") +
                ", reviews=" + uniReviews +
                '}';
    }
}
