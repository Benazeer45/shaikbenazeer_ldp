package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class Uni_InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) // No REMOVE cascade
    @JoinColumn(name = "id")
    private Uni_Instructor instructor;

    public Uni_InstructorDetail() {
    }

    public Uni_InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Uni_Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Uni_Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Bi_InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
