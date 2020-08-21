package com.tapandeat.foodtray.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cuisine {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("description")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Cuisine [name=" + name + ", description=" + description + "]";
	}

}
