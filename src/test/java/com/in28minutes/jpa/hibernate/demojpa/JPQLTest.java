package com.in28minutes.jpa.hibernate.demojpa;

import com.in28minutes.jpa.hibernate.demojpa.entity.Course;
import com.in28minutes.jpa.hibernate.demojpa.repository.CourseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes= DemojpaApplication.class)
class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	void jpql_basic() {
		List<Course> resultList = em.createQuery("Select c from Course c").getResultList();

		logger.info("Select c from Course c -> {}", resultList);

		logger.info("test is running contextLoads()");
		// Select c from Course c -> [Course{id=1, name='Webservices in 100 steps'}, Course{id=2, name='Angular Js in 100 steps - Updated'}, Course{id=3, name='Angular in 51'}, Course{id=10000, name='Trump is Great'}, Course{id=10001, name='JPA in 50 Steps'}, Course{id=10002, name='Spring in 50 Steps'}, Course{id=10003, name='Spring Boot in 100 Steps'}]
	}

	@Test
	public void jpql_query() {
		Query query = em.createQuery("Select c from Course c", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Query: Select c from Course c -> {}", resultList);
        assertFalse(resultList.isEmpty());
	}

	@Test
	public void jpql_namedQuery() {
		Query query = em.createNamedQuery("query_get_all_courses");
		List<Course> resultList = query.getResultList();
		logger.info("namedQuery: Select c from Course c -> {}", resultList);
        assertFalse(resultList.isEmpty());
	}

	@Test
	public void jpql_100_step_namedQuery() {
		Query query = em.createNamedQuery("query_get_100_step_courses");
		List resultList = query.getResultList();
		logger.info("namedQuery: Select c From Course c where name like '%100 Steps' -> {}", resultList);
		assertFalse(resultList.isEmpty());
	}
	@Test
	public void jpql_typed() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Select c from Course c -> {}", resultList);
	}
	@Test
	public void jpql_where() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c where c.name like '%100 Steps'", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Select c from Course c where c.name like '%100 Steps' -> {}", resultList);
	}
}
