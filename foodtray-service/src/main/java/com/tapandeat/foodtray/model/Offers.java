package com.tapandeat.foodtray.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Offers {

	@JsonProperty("name")
	private String name;

	@JsonProperty("terms")
	private String terms;

	@JsonProperty("discount")
	private int discount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Offers [name=" + name + ", terms=" + terms + ", discount=" + discount + "]";
	}

	
}
