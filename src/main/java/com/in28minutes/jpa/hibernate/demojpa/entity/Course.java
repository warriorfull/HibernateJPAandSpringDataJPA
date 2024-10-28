package com.in28minutes.jpa.hibernate.demojpa.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries(value = {
        @NamedQuery(name="query_get_all_courses", query="Select c From Course c"),
        @NamedQuery(name="query_get_100_step_courses", query="Select c From Course c where name like '%100 Steps'")
})
public class Course {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    // hibernate
    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime createdDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }

//    public void setReviews(List<Review> reviews) {
//        this.reviews = reviews;
//    }

    protected Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", reviews='"+reviews + '\'' +
                '}';
    }
}
