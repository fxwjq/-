package com.woniu.action;

import com.woniu.bean.Car;
import com.woniu.service.CarServiceImpl;
import com.woniu.service.ICarService;
import com.woniu.util.ActionInvocation;
import com.woniu.util.Interceptor;
import com.woniu.util.ProxyUtils;

public class AddInter implements Interceptor {
	private String price;
	private String brand;
	
	public AddInter() {}
	public AddInter(String price,String brand) {
		this.price = price;
		this.brand = brand;
	}
	
	public Object intercept(ActionInvocation invocation) throws Exception {
		ICarService car = new CarServiceImpl(); 
		AddInter interceptor = new AddInter();
		ICarService proxy = (ICarService)ProxyUtils.getProxy(car, interceptor);
		Car c = new Car();
		c.setBrand(brand);
		c.setPrice(price);
		proxy.add(c);
		char[] cLength = brand.toCharArray();
		if(cLength.length<5) {
			invocation.invoke();
		}
		return "add";
	}
}
