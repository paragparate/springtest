package com.parag.test.model01;

public class Car {
	String model;
	String make;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	@Override
	public String toString() {
		return "Car [model=" + model + ", make=" + make + "]";
	}
	
	
}
