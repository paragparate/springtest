package com.parag.test.model01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanInitTest {
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/root-context.xml");
		ctx.refresh();
		
//		Player p1 = Player.getBean("player1", ctx);
//		Player p2 = Player.getBean("player2", ctx);
//		Player p3 = Player.getBean("player3", ctx);

		System.out.println(ctx.getBean("&car"));
		
		ctx.close();

	}
}
