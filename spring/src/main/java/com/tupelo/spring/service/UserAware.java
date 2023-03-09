package com.tupelo.spring.service;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: caichuang
 * @Date: 2023/3/7 18:23
 */
@Component
public class UserAware implements EnvironmentAware {
	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("setEnvironment =======");
	}
	public UserAware(){
		System.out.println("UserAware init =======");
	}

	@PostConstruct
	public void doPostConstruct(){
		System.out.println("doPostConstruct ========== ");
	}

//	@PostConstruct
//	public void doDestory(){
//		System.out.println("doDestory ========== ");
//	}


	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize=======");
		super.finalize();
	}
}
