package com.tupelo.spring.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * @Author: caichuang
 * @Date: 2023/3/7 18:02
 */
@Component
public class TupeloBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

//		System.out.println("TupeloBeanFactoryPostProcessor ======");
//
//		Iterator<String> beanNamesIterator = configurableListableBeanFactory.getBeanNamesIterator();
//		while(beanNamesIterator.hasNext()) {
//			System.out.println(beanNamesIterator.next());
//		}

	}
}
