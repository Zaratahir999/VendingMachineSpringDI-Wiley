package com.exercise.dto;

import java.math.BigDecimal;

public class Items {
	
	private String name;
	private int quantity;
	private BigDecimal price;
	
	
	public Items(String name, BigDecimal price, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	

}
