package com.tapandeat.foodtray.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Price {

	@JsonProperty("name")
	private String name;
	@JsonProperty("price")
	private int price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Price [name=" + name + ", price=" + price + "]";
	}
	
}
