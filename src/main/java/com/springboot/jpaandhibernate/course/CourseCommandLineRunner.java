package com.springboot.jpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.jpaandhibernate.course.jpa.CourseJpaRepository;
import com.springboot.jpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

//	@Autowired
//	private CourseJdbcRepository repository;

//	@Autowired
//	private CourseJpaRepository repository;

	@Autowired
	private CourseSpringDataJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1, "Learn AWS Jpa!", "ahmed"));
		repository.save(new Course(2, "Learn Azure Jpa!", "ahmed"));
		repository.save(new Course(3, "Learn DevOps Jpa!", "ahmed"));

//		repository.insert(new Course(1, "Learn AWS Jpa!", "ahmed"));
//		repository.insert(new Course(2, "Learn Azure Jpa!", "ahmed"));
//		repository.insert(new Course(3, "Learn DevOps Jpa!", "ahmed"));
//
//
//		repository.deleteById(1l);
//
//		System.out.println(repository.findById(2l));
//		System.out.println(repository.findAll());

		System.out.println(repository.findAll());
		System.out.println(repository.count());

		System.out.println(repository.findByAuthor("ahmed"));
		System.out.println(repository.findByAuthor(""));

		System.out.println(repository.findByName("Learn AWS Jpa!"));
		System.out.println(repository.findByName("Learn DevOps Jpa!"));

		
	}

}
