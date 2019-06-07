package com.woniu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniu.bean.Car;
import com.woniu.util.JdbcUtil;

public class CarDaoImpl implements ICarDao {
	Connection conn = null;
	PreparedStatement stat = null;
	ResultSet rs = null;

	@Override
	public List<Car> findAll() {
		List<Car> list = new ArrayList<>();
		try { 
			conn = JdbcUtil.getconn();
			String sql = "select * from car";
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while (rs.next()) {
				Car car = new Car();
				car.setId(rs.getInt("id"));
				car.setBrand(rs.getString("brand"));
				car.setPrice(rs.getString("price"));
				list.add(car);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.free(rs, stat, conn);
		}
		
	}

	@Override
	public int getRowCount() {
		try {
			conn = JdbcUtil.getconn();
			String sql = "select count(*) from car";
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			int rowCount = 0;
			if (rs.next()) {
				rowCount = rs.getInt(1);
			}
			return rowCount;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.free(rs, stat, conn);
		}
	}

	@Override
	public List<Car> find(int start, int size) {
		try {
			conn = JdbcUtil.getconn();
			String sql = "select * from car limit ?,?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, start);
			stat.setInt(2, size);
			rs = stat.executeQuery();
			List<Car> list = new ArrayList<>();
			while (rs.next()) {
				Car car = new Car();
				car.setId(rs.getInt("id"));
				car.setBrand(rs.getString("brand"));
				car.setPrice(rs.getString("price"));
				list.add(car);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.free(rs, stat, conn);
		}
	}

	@Override
	public void delete(int id) {
		try {
			conn = JdbcUtil.getconn();
			String sql = "delete  from car where id=?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, id);
			stat.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("删除有误");
		} finally {
			JdbcUtil.free(rs, stat, conn);
		}
	}
	@Override
	public void update(Car c) {
		try {
			conn = JdbcUtil.getconn();
			String sql = "update car set brand = ?,price = ? where id= ?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, c.getBrand());
			stat.setString(2, c.getPrice());
			stat.setInt(3, c.getId());
			stat.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("修改有误");
		} finally {
			JdbcUtil.free(rs, stat, conn);
		}
	}

	@Override
	public void add(Car c) {
		try {
			conn = JdbcUtil.getconn();
			String sql = "insert  into car values(null,?,?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, c.getBrand());
			stat.setString(2, c.getPrice());
			stat.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("添加有误");
		} finally {
			JdbcUtil.free(rs, stat, conn);
		}
	}

	@Override
	public Car findOne(int id) {
		try {
			conn = JdbcUtil.getconn();
			Car car = null;
			String sql = "select * from car where id = ?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, id);
			rs = stat.executeQuery();
			while (rs.next()) {
				car = new Car();
				car.setId(rs.getInt("id"));
				car.setBrand(rs.getString("brand"));
				car.setPrice(rs.getString("price"));
			}
			return car;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.free(rs, stat, conn);
		}
	}
}
