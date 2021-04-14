package com.example.demo.domain;

public class Product {
	
	String name;
	String categroy;
	int price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategroy() {
		return categroy;
	}
	public void setCategroy(String categroy) {
		this.categroy = categroy;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Product(String name, String categroy, int price) {
		super();
		this.name = name;
		this.categroy = categroy;
		this.price = price;
	}
	public Product() {
		super();
	}
	

}
