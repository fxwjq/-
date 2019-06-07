package com.woniu.service;

import java.util.List;

import com.woniu.bean.Car;
import com.woniu.bean.Page;

public interface ICarService{
	List<Car> findAll();
	Car findOne(int id);
	Page findPageData(int p, int size);
	void delete(int id);
	void update(Car c);
	void add(Car c);
}
