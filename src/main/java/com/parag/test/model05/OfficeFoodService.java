package com.parag.test.model05;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//@Profile("office")
public class OfficeFoodService implements FoodService {

	@Override
	public List<Food> getMenu() {
		List<Food> menu = new ArrayList<Food>();
		
		menu.add(new Food("Chicken Sandwich", 1));
		menu.add(new Food("Fish and Chips", 2));
		menu.add(new Food("Black Coffee", 2));
		
		return menu;
	}
	
	@Bean
	public FoodService office() {
		return this;
	}

}
