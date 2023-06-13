package com.tupelo.design.service;

/**
 * @Author: caichuang
 * @Date: 2023/5/24 16:31
 */
public class StrangerClone extends Person implements Cloneable{

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public void doRun() {
		System.out.println("陌生人 doRun==");
	}

	@Override
	public void doSay() {
		System.out.println("陌生人 doSay==");
	}
}
