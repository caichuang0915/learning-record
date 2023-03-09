package com.tupelo.spring.proxy;

/**
 * @Author: caichuang
 * @Date: 2023/3/8 9:53
 */
public class ProxyServiceImpl implements ProxyService{
	@Override
	public String doTest() {
		System.out.println("记录日志 doTest..");
		return "haha";
	}
}
