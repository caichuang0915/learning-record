package com.tupeo.dubbo.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: caichuang
 * @Date: 2022/10/12 17:53
 */
@RestController
public class ConsumerController {


	@GetMapping("/doSend")
	public String doConsumer(){
		return "result";
	}

}
