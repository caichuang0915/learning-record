package com.tupelo.rpc.postprocessor;

import com.tupelo.rpc.proxy.RequestProxy;
import com.tupelo.rpc.registry.DiscoveryAnno;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @Author: caichuang
 * @Date: 2023/5/12 15:09
 */
@Component
public class RpcBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {

	private static RequestProxy requestProxy;

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		Field[] fields = bean.getClass().getDeclaredFields();
		for (Field field : fields) {
			if(!field.isAccessible()){
				field.setAccessible(true);
			}
			DiscoveryAnno annotation = field.getAnnotation(DiscoveryAnno.class);
			if(null==annotation){
				continue;
			}
			// 生成代理对象
			Class<?> type = field.getType();
			Object proxyInstance = requestProxy.createProxyObject(type);
			if(null!=proxyInstance){
				try {
					field.set(bean,proxyInstance);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return bean;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		requestProxy = applicationContext.getBean(RequestProxy.class);
	}
}
