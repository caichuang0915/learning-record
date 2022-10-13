package com.tupelo.spi.service;

import org.apache.dubbo.common.extension.SPI;

/**
 * @Author: caichuang
 * @Date: 2022/10/13 15:41
 */
@SPI
public interface DubboRobot {

	public void sayHello();
}
