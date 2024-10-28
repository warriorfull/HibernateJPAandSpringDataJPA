package com.in28minutes.jpa.hibernate.demojpa.repository;

import com.in28minutes.jpa.hibernate.demojpa.entity.Course;
import com.in28minutes.jpa.hibernate.demojpa.entity.Review;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public Course save(Course course) {
        // insert or update
        if (course.getId() == null) {
            // insert
            em.persist(course);
        } else {
            em.merge(course);
        }
        return course;
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        em.remove(course);
    }

    public void playWithEntityManager1() {
        logger.info("playWithEntityManager - start");
        Course course1 = new  Course("Webservices in 100 steps");
        em.persist(course1);
        Course course2 = new  Course("Angular Js in 100 steps");
        em.persist(course2);
        em.flush();

        course1.setName("Webservices in 100 steps - Updated");
        course2.setName("Angular Js in 100 steps - Updated");

        em.refresh(course1);
        
        em.flush();
    }

    public void playWithEntityManager() {
        Course course1 = new Course("Web Services in 100 Steps");
        em.persist(course1);

        Course course2 = findById(10001L);
        course2.setName("JPA in 50 Steps - Updated");

//        course1.setName(null);
        em.flush();
    }

    public void addReviewsForCourse() {
        // get the course 10003
        Course course = findById(10003L);
        logger.info("course.getReviews() -> {}",course.getReviews());
        // add 2 reviews to it
        Review review1 = new Review("5", "Great Hands-on Stuff.");
        Review review2 = new Review("5", "Hatsoff.");

        // setting the relationship
        course.addReview(review1);
        review1.setCourse(course);

        course.addReview(review2);
        review2.setCourse(course);

        // save it to the database
        em.persist(review1);
        em.persist(review2);
    }
}
