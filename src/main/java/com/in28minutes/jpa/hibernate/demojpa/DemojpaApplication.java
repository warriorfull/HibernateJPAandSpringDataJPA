package com.in28minutes.jpa.hibernate.demojpa;

import com.in28minutes.jpa.hibernate.demojpa.entity.Course;
import com.in28minutes.jpa.hibernate.demojpa.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.demojpa.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		studentRepository.saveStudentWithPassport();

//		Course course = courseRepository.findById(10001L);
//		logger.info(String.valueOf(course));
//
//		courseRepository.save(new Course("Microservices in 100"));
//		courseRepository.save(new Course("Angular in 51"));

		courseRepository.playWithEntityManager();
		courseRepository.save(new Course("Angular in 51"));
	}
}
