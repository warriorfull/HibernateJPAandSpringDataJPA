package com.in28minutes.jpa.hibernate.demojpa;

import com.in28minutes.jpa.hibernate.demojpa.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes= DemojpaApplication.class)
class NativeQueriesTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	public void native_queries_basic() {
		Query query = em.createNativeQuery("Select * from course", Course.class);
		List<Course> resultSet = query.getResultList();
		logger.info("Select * from course ->{}", resultSet);
	}

	@Test
	public void native_queries_with_parameter() {
		Query query = em.createNativeQuery("Select * from course where id = ?", Course.class);
		query.setParameter(1, 10001L);
		List<Course> resultSet = query.getResultList();
		logger.info("Select * from course where id = ? ->{}", resultSet);
	}

	@Test
	public void native_queries_with_named_parameter() {
		Query query = em.createNativeQuery("Select * from course where id = :id", Course.class);
		query.setParameter("id", 10001L);
		List<Course> resultSet = query.getResultList();
		logger.info("Select * from course where id = :id ->{}", resultSet);
	}
	@Test
	@Transactional
	public void native_queries_to_update() {
		Query query = em.createNativeQuery("update course set last_updated_date=current_date()", Course.class);
		int noOfRowsUpdated = query.executeUpdate();
		logger.info("update course set last_updated_date=current_date() ->{}", noOfRowsUpdated);
	}

}
