package com.tupelo.vote;

import com.tupelo.vote.service.SendService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication

public class VoteApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(VoteApplication.class, args);

		SendService sendService = context.getBean(SendService.class);


//		sendService.sendSms("13621071111");
		sendService.loginAndVote("13621073059");



	}

}
