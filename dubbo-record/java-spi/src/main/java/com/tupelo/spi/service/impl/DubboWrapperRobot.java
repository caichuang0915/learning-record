package com.tupelo.spi.service.impl;

import com.tupelo.spi.service.DubboRobot;


/**
 * @Author: caichuang
 * @Date: 2022/10/13 15:41
 */
public class DubboWrapperRobot implements DubboRobot {

	private DubboRobot DubboRobot;

	public DubboWrapperRobot(DubboRobot dubboRobot) {
		DubboRobot = dubboRobot;
	}

	@Override
	public void sayHello() {

//		dubboTest.doTest("mm");

		System.out.println("wrapper bengin ====");

		DubboRobot.sayHello();

		System.out.println("wrapper end ====");
	}
}
