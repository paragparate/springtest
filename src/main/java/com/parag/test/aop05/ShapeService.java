package com.parag.test.aop05;

public class ShapeService {
	private Circle circle;
	private Triangle triangle;
	
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
	@Override
	public String toString() {
		return "ShapeService [circle=" + circle + ", triangle=" + triangle + "]";
	}
	
	
}
