package org.example;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Bi_Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private Bi_InstructorDetail instructorDetail;

    @OneToMany(mappedBy = "instructor",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Bi_Course> courses;

    public Bi_Instructor() {
    }

    // Parameterized constructor
    public Bi_Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Bi_InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(Bi_InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    public List<Bi_Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Bi_Course> courses) {
        this.courses = courses;
    }

    // Convenience method to add a course and set the bidirectional relationship
    public void addCourse(Bi_Course tempCourse) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(tempCourse);
        tempCourse.setInstructor(this); // Set the instructor for bidirectional relationship
    }

    // toString method to display Instructor details
    @Override
    public String toString() {
        return "Bi_Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetail=" + instructorDetail +
                ", courses=" + courses +
                '}';
    }
}