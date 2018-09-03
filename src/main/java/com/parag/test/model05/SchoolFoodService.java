package com.parag.test.model05;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//@Profile("school")
public class SchoolFoodService implements FoodService {

	@Override
	public List<Food> getMenu() {
		List<Food> menu = new ArrayList<Food>();
		
		menu.add(new Food("Mango Juice", 1));
		menu.add(new Food("Rice and Beans", 1));
		menu.add(new Food("Candies", 3));
		
		return menu;
	}
	
	@Bean
	public FoodService school() {
		return this;
	}

}
