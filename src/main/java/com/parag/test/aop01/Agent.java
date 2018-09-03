package com.parag.test.aop01;

import org.springframework.stereotype.Component;

@Component
public class Agent {

	public void speak() {
		System.out.print("Bond");
	}
}
