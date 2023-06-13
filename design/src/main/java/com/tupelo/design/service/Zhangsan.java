package com.tupelo.design.service;

/**
 * @Author: caichuang
 * @Date: 2023/5/24 16:31
 */
public class Zhangsan extends Person{

	@Override
	public void doRun() {
		System.out.println("张三 doRun==");
	}

	@Override
	public void doSay() {
		System.out.println("张三 doSay==");
	}
}
