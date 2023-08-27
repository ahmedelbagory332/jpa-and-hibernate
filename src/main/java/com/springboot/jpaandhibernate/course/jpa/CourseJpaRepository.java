package com.springboot.jpaandhibernate.course.jpa;

import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.springboot.jpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public class CourseJpaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}

	public List<Course> findAll() {
		TypedQuery<Course> query = entityManager.createQuery("SELECT c FROM Course c", Course.class);
		return query.getResultList();
	}

	public void deleteById(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}

}
