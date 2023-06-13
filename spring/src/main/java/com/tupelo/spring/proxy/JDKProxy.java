package com.tupelo.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: caichuang
 * @Date: 2023/3/8 9:32
 */
public class JDKProxy implements InvocationHandler {


	private Object target;

	public JDKProxy(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("记录日志 before");

		Object res = method.invoke(target, args);

		System.out.println("记录日志 after");

		return res;
	}


	public static void main(String[] args) {
		ProxyService proxyService = new ProxyServiceImpl();
		JDKProxy jdkProxy = new JDKProxy(proxyService);
		ProxyService ps = (ProxyService)Proxy.newProxyInstance(proxyService.getClass().getClassLoader(), proxyService.getClass().getInterfaces(), jdkProxy);
		String s = ps.doTest();
		System.out.println(s);

	}
}
