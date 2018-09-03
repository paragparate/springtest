package com.parag.test.model03;

import java.util.Locale;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericXmlApplicationContext;

@Configuration
@ComponentScan(basePackages= {"com.parag.test.model03"})
public class CollectionTest {

	public static void main(String[] args) {
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(CollectionTest.class);
//		CollectionClass collection = (CollectionClass)ctx.getBean("myCollection");
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/root-context.xml");
		ctx.refresh();
		
		String lang = "de";
		String loc = "FR";
		
		System.out.println(ctx.getMessage("msg", new Object[] {"Sonal","Parate"}, "Forgot to define your language", new Locale(lang, loc)));
//		System.out.println(ctx.getMessage("msg", new Object[] {"Parag","Parate"}, new Locale("fr", "CA")));
		
//		CollectionClass collection = (CollectionClass)ctx.getBean("myCollection");		
		
//		System.out.println(collection);
	}
}
