package com.tupelo.design.service;

/**
 * @Author: caichuang
 * @Date: 2023/5/24 16:31
 */
public class LisiDecorator extends Decorator {

	@Override
	public void doRun() {
		super.doRun();
		System.out.println("lisi doRun decorator");
	}
}
