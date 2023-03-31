package com.tupelo.spring;

import com.tupelo.spring.service.OrderService;
import com.tupelo.spring.service.UserAware;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		ApplicationContext applicationContext = UserAware.getApplicationContext();
		OrderService bean = applicationContext.getBean(OrderService.class);
		System.out.println(bean);
	}

}
