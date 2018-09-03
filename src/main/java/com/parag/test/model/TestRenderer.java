package com.parag.test.model;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.parag.test.model")
public class TestRenderer {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TestRenderer.class);
		MessageRenderer renderer = (MessageRenderer) ctx.getBean("renderer");
		renderer.render();
	}
	
}
