package com.tupelo.spi.service.impl;

import com.tupelo.spi.service.Robot;

/**
 * @Author: caichuang
 * @Date: 2022/10/13 15:41
 */
public class BRobot implements Robot {
	@Override
	public void sayHello() {
		System.out.println("I am B");
	}
}
