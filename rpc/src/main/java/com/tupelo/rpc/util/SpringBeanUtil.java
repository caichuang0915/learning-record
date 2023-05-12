package com.tupelo.rpc.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @Author: caichuang
 * @Date: 2023/5/11 17:42
 */
@Configuration
@Order(1)
public class SpringBeanUtil implements ApplicationContextAware, PriorityOrdered {

	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

	public static Map<String, Object> getBeansByAnno(Class<? extends Annotation> var1){
		 return context.getBeansWithAnnotation(var1);
	}


	public static Object getBean(String s){
		return context.getBean(s);
	}

	public static <T> T getBean(Class<T> s){
		return context.getBean(s);
	}


	@Override
	public int getOrder() {
		return 0;
	}
}
