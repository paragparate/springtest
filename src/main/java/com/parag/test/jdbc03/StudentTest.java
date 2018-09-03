package com.parag.test.jdbc03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DbConfig.class);
		Student student = ctx.getBean("studentDAO", StudentDAO.class).findById(5);
		System.out.println(student);	
		
		Student newStudent = new Student();
		newStudent.setFirstName("Bustan");
		newStudent.setLastName("Bhaguna");
		newStudent.setEmail("bb@vines.com");
		
		ctx.getBean("studentDAO", StudentDAO.class).insert(newStudent);
	}	
}
