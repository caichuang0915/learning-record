package com.tupelo.spi.service;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @Author: caichuang
 * @Date: 2022/10/13 15:41
 */
@SPI("DubboATest")
public interface DubboTest {

	@Adaptive
	public void doTest(String mm);
}
