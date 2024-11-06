package com.in28minutes.jpa.hibernate.demojpa;

import com.in28minutes.jpa.hibernate.demojpa.entity.Course;
import com.in28minutes.jpa.hibernate.demojpa.entity.Review;
import com.in28minutes.jpa.hibernate.demojpa.repository.CourseRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes= DemojpaApplication.class)
class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;

	@Autowired
	EntityManager em;

	@Test
	@DirtiesContext
	void findById_basic() {
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 Steps - Updated", course.getName());

		logger.info("test is running contextLoads()");
	}

	@Test
	@DirtiesContext
	public void deleteById_basic() {
		repository.deleteById(10001L);
		assertNull(repository.findById(10001L));
	}

	@Test
	@DirtiesContext
	public void save_basic_save() {
		Course course = repository.save(new Course("Awesome Course in 5 steps"));
		assertEquals("Awesome Course in 5 steps", course.getName());
	}

	@Test
	@DirtiesContext
	public void save_basic() {
		Course course1 = repository.findById(10001L);
		course1.setName("JPA is updated");
		Course course = repository.save(course1);
		assertEquals("JPA is updated", course.getName());
	}

	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		repository.playWithEntityManager();
	}

	@Test
	@Transactional
	public void retrieveReviewForCourse() {
		Course course = repository.findById(10001L);
		List<Review> reviews = course.getReviews();
		logger.info("course.getReviews(): {}", course.getReviews());
	}

	@Test
	@Transactional
	public void retrieveCourseForReview() {
		Review review = em.find(Review.class, 50001L);
		logger.info("review.getCourse: {}", review.getCourse());
	}
}
