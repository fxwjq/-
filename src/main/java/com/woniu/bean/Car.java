package com.woniu.bean;

import java.io.Serializable;

public class Car implements Serializable{
	@Override
	public String toString() {
		return "CarBean [id=" + id + ", brand=" + brand + ", price=" + price + "]";
	}

	private int id;
	private String brand;
	private String price;
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
