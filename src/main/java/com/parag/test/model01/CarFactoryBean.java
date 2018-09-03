package com.parag.test.model01;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car>{

	Car car;
	
	@Override
	public Car getObject() throws Exception {
		// TODO Auto-generated method stub
		car = new Car();
		car.setModel("Ferarri");
		car.setMake("2001");
		return car;
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
