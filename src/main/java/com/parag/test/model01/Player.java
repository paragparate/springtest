package com.parag.test.model01;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Player implements InitializingBean {
	public static final String DEFAULT_NAME = "Parag Parate";
	
	private String name;
	private int age = Integer.MIN_VALUE;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", age=" + age + "]";
	}	
	
	public static Player getBean(String beanName, ApplicationContext ctx) {
		
		try {
		Player player = (Player) ctx.getBean(beanName);
		System.out.println(player);
		return player;
		}
		catch (BeanCreationException e) {
			System.out.println("Exception occurred in bean configuration");
			return null;
		}
	}
	
	@PostConstruct
 	public void init() throws Exception {
		System.out.println("Init called on "+this);
		
		if (this.name == null) {
			name = DEFAULT_NAME;
		}
		
		if (this.age == Integer.MIN_VALUE) {
			throw new IllegalArgumentException("Your player forgot to take birth!");
		}
		
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void destroy() {
		System.out.println("DID coz I'm winding up - Fk you i'm going home X-/");
	}
	
}
