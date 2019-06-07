package com.woniu.util;

import java.lang.reflect.Method;

public//这个类有调用真实方法的东西
class ActionInvocation {
	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	private Method method;
	private Object target;
	private Object[] args;
	public ActionInvocation(Method method, Object target, Object[] args) {
		super();
		this.method = method;
		this.target = target;
		this.args = args;
	}
	
	public Object invoke() throws Exception {
		return method.invoke(target, args);
	}
	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}
}
