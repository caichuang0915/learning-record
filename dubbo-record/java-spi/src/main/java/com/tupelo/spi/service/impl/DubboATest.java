package com.tupelo.spi.service.impl;

import com.tupelo.spi.service.DubboTest;
import org.apache.dubbo.common.URL;

/**
 * @Author: caichuang
 * @Date: 2022/10/13 15:41
 */
public class DubboATest implements DubboTest {

	@Override
	public void doTest(String mm) {
		System.out.println("I am DubboATest " + mm);
	}
}
