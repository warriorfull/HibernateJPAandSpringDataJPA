package com.in28minutes.jpa.hibernate.demojpa;

import com.in28minutes.jpa.hibernate.demojpa.entity.Course;
import com.in28minutes.jpa.hibernate.demojpa.entity.Student;
import com.in28minutes.jpa.hibernate.demojpa.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.demojpa.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes= DemojpaApplication.class)
class StudentRepositoryTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;

	@Autowired
	EntityManager em;

	@Test
//	@DirtiesContext
	@Transactional
	void retrieveStudentAndPasswordDetails() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student -> {}", student);
		logger.info("password -> {}", student.getPassport());

	}

}
