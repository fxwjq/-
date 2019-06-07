package com.woniu.service;

import java.util.List;

import com.woniu.bean.Car;
import com.woniu.bean.Page;
import com.woniu.dao.CarDaoImpl;
import com.woniu.dao.ICarDao;

public class CarServiceImpl implements ICarService {
	ICarDao dao = new CarDaoImpl();
	@Override
	public List<Car> findAll() {
		return dao.findAll();
	}
	
	@Override
	public Page findPageData(int p, int size) {
		int rowCount  = dao.getRowCount();
		Page page = new Page(p,rowCount,size);
		List<Car> car = dao.find(p, size);
		 page.setList(car);
		 return page;
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public void update(Car c) {
		dao.update(c);
	}

	@Override
	public void add(Car c) {
		dao.add(c);
	}

	@Override
	public Car findOne(int id) {
		return  dao.findOne(id);
	}

}
