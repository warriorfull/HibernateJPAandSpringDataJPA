package com.in28minutes.jpa.hibernate.demojpa;

import com.in28minutes.jpa.hibernate.demojpa.entity.Course;
import com.in28minutes.jpa.hibernate.demojpa.entity.Review;
import com.in28minutes.jpa.hibernate.demojpa.entity.Student;
import com.in28minutes.jpa.hibernate.demojpa.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.demojpa.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemojpaApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemojpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		studentRepository.saveStudentWithPassport();
//		courseRepository.playWithEntityManager();
//		courseRepository.addHardcodedReviewsForCourse();


//		List<Review> reviews = new ArrayList<>();
//		reviews.add(new Review("5", "X Great Hands-on Stuff."));
//		reviews.add(new Review("5", "X Hatsoff."));
//		courseRepository.addReviewsForCourse(10003L, reviews);


//		Course course = courseRepository.findById(10001L);
//		logger.info(String.valueOf(course));
//		courseRepository.save(new Course("Microservices in 100"));
//		courseRepository.save(new Course("Angular in 51"));

//		studentRepository.insertHardcodedStudentAndCourse();


		Student student = new Student("~Jack");
		Course course = new Course("~Microservices in 100 Steps");
		studentRepository.insertStudentAndCourse(student, course);
	}


}
