package com.in28minutes.jpa.hibernate.demojpa.entity;

import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    private String rating;

    private String description;

    @ManyToOne
    private Course course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRating() { return rating; }

    public void setRating(String rating) { this.rating = rating; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    protected Review() {
    }

    public Review(String rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Review {" +
//                "id=" + id +
//                ", rating =" + rating +
//                ", description ='" + description + '\'' +
//                ", course =" + course +
                '}';
    }
}
