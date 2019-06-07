package com.woniu.dao;

import java.util.List;

import com.woniu.bean.Car;

public interface ICarDao {
List<Car> findAll();
Car findOne(int id);
int getRowCount(); //获取总行数
List<Car> find(int start, int size);//获取分页数据
void delete(int id);
void update(Car c);
void add(Car c);
}