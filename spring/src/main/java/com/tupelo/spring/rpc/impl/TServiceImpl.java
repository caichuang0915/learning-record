package com.tupelo.spring.rpc.impl;

import com.tupelo.rpc.registry.RegistryAnno;
import com.tupelo.spring.rpc.service.TService;
import org.springframework.stereotype.Service;

/**
 * @Author: caichuang
 * @Date: 2023/5/11 18:07
 */
@Service
@RegistryAnno(interfaceClass = TService.class)
public class TServiceImpl implements TService {

	@Override
	public String doTest() {
		return "doTest";
	}
}
