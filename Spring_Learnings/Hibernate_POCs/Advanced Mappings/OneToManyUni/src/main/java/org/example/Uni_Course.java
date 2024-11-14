//package org.example;
//
//import jakarta.persistence.*;
//
//import java.util.List;
//
//@Entity
//@Table(name = "course")
//public class Bi_Course {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private int id;
//
//    @Column(name = "title")
//    private String title;
//
//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
//    @JoinColumn(name = "instructor_id")
//    private Bi_Instructor instructor;
//
//    private List<Review> reviews;
//
//    public Bi_Course() {
//    }
//
//    public Bi_Course(String title) {
//        this.title = title;
//    }
//
//    // Getters and Setters
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public Bi_Instructor getInstructor() {
//        return instructor;
//    }
//
//    public void setInstructor(Bi_Instructor instructor) {
//        this.instructor = instructor;
//    }
//
//    @Override
//    public String toString() {
//        return "Course{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", instructor=" + (instructor != null ? instructor.getId() : "null") +
//                '}';
//    }
//}


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
    private List<Uni_Review> uniReviews;

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

    // Convenience method to add a review
    public void addReview(Uni_Review uniReview) {
        if (uniReviews == null) {
            uniReviews = new ArrayList<>();
        }
        uniReviews.add(uniReview);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor=" + (instructor != null ? instructor.getId() : "null") +
                ", reviews=" + uniReviews +
                '}';
    }
}

