package com.tupelo.spi.service.impl;

import com.tupelo.spi.service.DubboRobot;

/**
 * @Author: caichuang
 * @Date: 2022/10/13 15:41
 */
public class DubboBRobot implements DubboRobot {
	@Override
	public void sayHello() {
		System.out.println("I am dubbo B");
	}
}
