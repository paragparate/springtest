package com.parag.test.model04;

import org.springframework.context.ApplicationEvent;

public class EventMessege extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	String message;
	
	public EventMessege(String msg, Object source) {
		super(source);
		this.message = msg;		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
