package com.woniu.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class Myhandle implements InvocationHandler{
	Object target;
	Interceptor interceptor;
	//这儿invoke方法可以调用真实的方法，但是需要有一个对象 以及  需要给客户留的接口
	public Myhandle(Object target,Interceptor interceptor) {
		this.target = target;
		this.interceptor = interceptor;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return interceptor.intercept(new ActionInvocation(method,target,args));
	}
	
}

public class ProxyUtils {
	/**
	 * 
	 * @param target 谁这真正要代理的对象
	 * @param interceptor 你用这个方法想加哪些功能 留一个接口给你
	 * @return
	 */
	public static Object getProxy(Object target,Interceptor interceptor) {
		//获取类加载器
		 ClassLoader loader = ProxyUtils.class.getClassLoader();
		 //获取一个类实现的接口集合
		 Class[] interfaces = target.getClass().getInterfaces();//确定由该对象表示的类或接口实现的接口。
		 //第三个参数是invocationhandle的实现类 或者直接匿名内部类
		 Myhandle h = new Myhandle(target,interceptor);
		 Object proxy = Proxy.newProxyInstance(loader, interfaces, h);
		 return proxy;
	}
}
