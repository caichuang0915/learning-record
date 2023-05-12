package com.tupelo.spring;

import com.tupelo.rpc.RpcBootStrap;
import com.tupelo.rpc.RpcClientBootStrap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.tupelo"})
@Slf4j
public class Application {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		log.info("服务启动成功");

		RpcBootStrap server = context.getBean(RpcBootStrap.class);
		RpcClientBootStrap client = context.getBean(RpcClientBootStrap.class);

		server.init();
//		client.init();

	}

}
