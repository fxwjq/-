package com.woniu.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Car implements Serializable{
	@Override
	public String toString() {
		return "CarBean [id=" + id + ", brand=" + brand + ", price=" + price + "]";
	}

	private int id;
	private String brand;
	private String price;
	private Set<String> address = new HashSet<>();
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}


}
