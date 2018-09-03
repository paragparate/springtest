package com.parag.test.model04;

import org.springframework.context.ApplicationListener;

public class EventListener implements ApplicationListener<EventMessege> {

	@Override
	public void onApplicationEvent(EventMessege event) {		
		System.out.println("Your message - " + event.getMessage());
	}

}
