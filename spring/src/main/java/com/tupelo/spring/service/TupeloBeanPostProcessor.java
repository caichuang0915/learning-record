package com.tupelo.spring.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: caichuang
 * @Date: 2023/3/7 18:23
 */
@Component
public class TupeloBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization ===========" + beanName);
		return null;
	}
//
//	@Override
//	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//		System.out.println("postProcessBeforeInitialization ===========" + beanName);
//		return null;
//	}
}
