package com.tupelo.spring.proxy;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: caichuang
 * @Date: 2023/3/8 9:32
 */
public class TestProxy implements InvocationHandler {


	private Object object;


	public TestProxy(Object object) {
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(111);
		return method.invoke(object,args);
	}




	public static void main(String[] args) {

		ProxyService proxyService = new ProxyServiceImpl();


//		ProxyService proxyService1 = (ProxyService)Proxy.newProxyInstance(proxyService.getClass().getClassLoader(), new Class[]{ProxyService.class}, new InvocationHandler() {
//			@Override
//			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//				System.out.println(333);
//				return method.invoke(proxyService,args);
//			}
//		});
//		proxyService1.doTest();

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(ProxyService.class);
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
				System.out.println(222);
				return method.invoke(proxyService,objects);
			}
		});
		ProxyService proxyService1 = (ProxyService)enhancer.create();
		proxyService1.doTest();
	}

}
