package com.parag.test.model05;

public class Food {
	String item;
	int quantity;
	
	public Food() {
		super();
	}
	
	public Food(String item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Food [item=" + item + ", quantity=" + quantity + "]";
	}
	
	
}
