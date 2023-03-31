package com.tupelo.spring.service;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @Author: caichuang
 * @Date: 2023/3/7 18:21
 */
@Service
public class MyFactoryBean implements FactoryBean<OrderService> {

	@Override
	public OrderService getObject() throws Exception {
		return null;
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}
}
