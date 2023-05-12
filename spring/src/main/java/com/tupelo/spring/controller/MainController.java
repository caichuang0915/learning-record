package com.tupelo.spring.controller;

import com.tupelo.rpc.registry.DiscoveryAnno;
import com.tupelo.spring.rpc.service.TService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: caichuang
 * @Date: 2023/5/12 15:29
 */
@RestController
public class MainController {

	@DiscoveryAnno
	private TService tService;


	@RequestMapping("/first")
	public String rpcTest() {
		return tService.doTest();
	}
}
