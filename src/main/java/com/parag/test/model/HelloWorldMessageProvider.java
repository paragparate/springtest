package com.parag.test.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("provider")
public class HelloWorldMessageProvider implements MessageProvider{
	
	String message;
	
	public HelloWorldMessageProvider() {
	}
	
	@Autowired
	public HelloWorldMessageProvider(@Value("${root.greeting}") String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
