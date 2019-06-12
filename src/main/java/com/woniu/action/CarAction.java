package com.woniu.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.woniu.bean.Car;
import com.woniu.bean.Page;
import com.woniu.service.CarServiceImpl;
import com.woniu.service.ICarService;
import com.woniu.util.ActionInvocation;
import com.woniu.util.Interceptor;
import com.woniu.util.ProxyUtils;

public class CarAction extends ActionSupport implements Interceptor {
	Car car = null;
	ICarService service = new CarServiceImpl();
	private int p;
	private int id;
	private String price;
	private String brand;
	
	public String add() {
		ICarService carser = new CarServiceImpl(); 
		car = new Car();
		ICarService proxy = (ICarService)ProxyUtils.getProxy(carser, new CarAction());
		car.setPrice(price);
		car.setBrand(brand);
		proxy.add(car);
		return "add" ;
	}
	public String show(){
		Page page = service.findPageData(p, 5);
		ServletActionContext.getRequest().setAttribute("page", page);
		return "show";
	}
	//删除完成应该进入一个action 然后再进入show方法
	public String delete() {
		ICarService carser = new CarServiceImpl(); 
		ICarService proxy = (ICarService)ProxyUtils.getProxy(carser, new CarAction());
		proxy.delete(id);
		return "del";
	}
	public String update() {
		car = new Car();
		car.setPrice(price);
		car.setBrand(brand);
		car.setId(id);
		service.update(car);
		return "update";
	}
	
	public String findOne() {
		car = service.findOne(id);
		ServletActionContext.getRequest().setAttribute("car", car);
		return "findOne";
	}
	public String findByName() {
	System.out.println(brand);
		return null;
	}
	
	public void setP(int p) {
		this.p = p;
	}

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
	@Override
	public Object intercept(ActionInvocation invocation) throws Exception {
		if("add".equals(invocation.getMethod().getName())) {
			//System.out.println(brand);
			car = (Car)invocation.getArgs()[0];
			char[] cLength = car.getBrand().toCharArray();
			if(cLength.length<5) {
				invocation.invoke();
			}
		}else if("delete".equals(invocation.getMethod().getName())) {
			id = (int)invocation.getArgs()[0];
			car = service.findOne(id);//删除时还有一个查一个的过程
			if(Double.parseDouble(car.getPrice())<500) {
				invocation.invoke();
			}
		}
		return null;//这个返回值应该根据实际情况定夺
	}
}
