package com.parag.test.aop05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:spring/root-context.xml");

		ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
		shapeService.getCircle().setName("Yuhu Circle");
		System.out.println(shapeService.getCircle().getName());
		System.out.println(shapeService.getTriangle().getName());
	}
}
