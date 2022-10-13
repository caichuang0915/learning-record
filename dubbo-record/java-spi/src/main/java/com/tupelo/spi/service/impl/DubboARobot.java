package com.tupelo.spi.service.impl;

import com.tupelo.spi.service.DubboRobot;
import com.tupelo.spi.service.DubboTest;

/**
 * @Author: caichuang
 * @Date: 2022/10/13 15:41
 */
public class DubboARobot implements DubboRobot {

	private DubboTest dubboTest;



	public void setDubboTest(DubboTest dubboTest){
		this.dubboTest = dubboTest;
	}


	@Override
	public void sayHello() {

//		dubboTest.doTest("mm");

		System.out.println(dubboTest);
		System.out.println("I am dubbo A");
	}
}
