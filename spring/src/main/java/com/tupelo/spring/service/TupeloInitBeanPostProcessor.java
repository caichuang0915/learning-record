//package com.tupelo.spring.service;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
//import org.springframework.stereotype.Component;
//
///**
// * @Author: caichuang
// * @Date: 2023/3/7 18:23
// */
//@Component
//public class TupeloInitBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
//
//	@Override
//	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//		System.out.println(beanName + "  postProcessBeforeInitialization ----------");
//		return null;
//	}
//
//	@Override
//	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//		System.out.println(beanName + "  postProcessAfterInitialization  ***************");
//		return null;
//	}
//}
