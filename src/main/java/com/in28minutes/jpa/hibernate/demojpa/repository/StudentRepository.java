package com.in28minutes.jpa.hibernate.demojpa.repository;

import com.in28minutes.jpa.hibernate.demojpa.entity.Course;
import com.in28minutes.jpa.hibernate.demojpa.entity.Passport;
import com.in28minutes.jpa.hibernate.demojpa.entity.Student;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    public Student save(Student student) {
        // insert or update
        if (student.getId() == null) {
            // insert
            em.persist(student);
        } else {
            em.merge(student);
        }
        return student;
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        em.remove(student);
    }

    public void playWithEntityManager1() {
        logger.info("playWithEntityManager - start");
        Student student1 = new  Student("Webservices in 100 steps");
        em.persist(student1);
        Student student2 = new  Student("Angular Js in 100 steps");
        em.persist(student2);
        em.flush();

        student1.setName("Webservices in 100 steps - Updated");
        student2.setName("Angular Js in 100 steps - Updated");

        em.refresh(student1);
        
        em.flush();
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport("Z123456");
        em.persist(passport);
        Student student = new Student("Mike");
        student.setPassport(passport);
        em.persist(student);
    }

    public void insertHardcodedStudentAndCourse() {
        Student student = new Student("Jack");
        Course course = new Course("Microservices in 100 Steps");
        em.persist(student);
        em.persist(course);

        student.addCourse(course);
        course.addStudent(student);

        em.persist(student);
    }

    public void insertStudentAndCourse(Student student, Course course) {
        student.addCourse(course);
        course.addStudent(student);

        Student student2 = new Student("Jake");
        student2.addCourse(course);
        course.addStudent(student2);

        em.persist(student);
        em.persist(course);
        em.persist(student2);
    }
}
