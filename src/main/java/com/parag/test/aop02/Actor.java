package com.parag.test.aop02;

public class Actor {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Actor [name=" + name + "]";
	}
	
	public String act(String line) {
		System.out.println(this.name+": "+line);
		return this.name+": "+line;
	}
}
