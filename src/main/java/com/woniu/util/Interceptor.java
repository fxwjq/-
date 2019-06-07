package com.woniu.util;

public interface Interceptor{
	Object intercept(ActionInvocation invocation)throws Exception;
}