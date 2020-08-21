package com.tapandeat.foodtray.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Items {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("price")
	private int price;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("image")
	private String image;
	
	@JsonProperty("cuisine")
	private Cuisine cuisine;
	
	@JsonProperty("offers")
	private Offers offers;

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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Cuisine getCuisine() {
		return cuisine;
	}


	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}


	public Offers getOffers() {
		return offers;
	}


	public void setOffers(Offers offers) {
		this.offers = offers;
	}


	@Override
	public String toString() {
		return "Items [name=" + name + ", price=" + price + ", description=" + description + ", image=" + image
				+ ", cuisine=" + cuisine + ", offers=" + offers + "]";
	}


	
	
}
