package com.tupelo.spring.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: caichuang
 * @Date: 2023/3/8 9:32
 */
public class CglibProxy implements MethodInterceptor {

	private Object targetObject;

	public Object createProxyObject(Object obj) {
		this.targetObject = obj;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(obj.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("before ===== ");
		Object invoke = method.invoke(targetObject, objects);
		System.out.println("after ===== ");
		return invoke;
	}


	public static void main(String[] args) {
		ProxyService proxyService = new ProxyServiceImpl();
		CglibProxy cglibProxy = new CglibProxy();
		ProxyService proxy = (ProxyService)cglibProxy.createProxyObject(proxyService);
		String s = proxy.doTest();
		System.out.println(s);
	}
}
