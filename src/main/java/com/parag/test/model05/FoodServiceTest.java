package com.parag.test.model05;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.test.context.ActiveProfiles;

@ComponentScan(basePackages= {"com.parag.test.model05"})
@ActiveProfiles("office")
 public class FoodServiceTest {

	@Autowired
	@Qualifier("school")
	static FoodService fs;
	static ApplicationContext ctx;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SchoolFoodService.class, OfficeFoodService.class);
		
//		for (String bean: ctx.getBeanDefinitionNames()) 
//			System.out.println(bean);
//		
//		System.out.println(fs);
		
		ConfigurableEnvironment env = ctx.getEnvironment();
		MutablePropertySources src = env.getPropertySources();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
//		for (Object obj : env.getSystemProperties().entrySet().toArray())
//			System.out.println(obj);
		
		map.put("whoLetTheDogsOut", "Parag");
		src.addFirst(new MapPropertySource("pp_config", map));
		System.out.println(System.getProperty("whoLetTheDogsOut"));
		System.out.println(env.getProperty("whoLetTheDogsOut"));
		
		ctx.close();
	}
 
}
