package com.parag.test.model04;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericXmlApplicationContext;

public class EventPublisher implements ApplicationContextAware {

	ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx = applicationContext;
	}
	
	public void publish(String message) {
		ctx.publishEvent(new EventMessege(message, this));
	}
	
	public static void main(String[] args) throws IOException {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/root-context.xml");
		ctx.refresh();
		
		EventPublisher publisher = (EventPublisher) ctx.getBean("publisher");
		publisher.publish("Hello! Penny Menny");
		publisher.publish("Yawsie Pensie");
		
		System.out.println(ctx.getResource("http://www.google.com").getInputStream());
	}

}
