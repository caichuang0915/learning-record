package com.tupelo.security.controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: caichuang
 * @Date: 2023/4/6 11:12
 */
@RestController
public class DoController {

	@GetMapping("/mm")
	public String doMain(){
		return "1111";
	}
}
