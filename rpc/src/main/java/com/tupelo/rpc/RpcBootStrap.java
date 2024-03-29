package com.tupelo.rpc;

import com.tupelo.rpc.registry.RpcRegistry;
import com.tupelo.rpc.util.SpringBeanUtil;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @Author: caichuang
 * @Date: 2023/5/11 18:11
 */
@Configuration
public class RpcBootStrap  {


	@Resource
	private RpcRegistry rpcRegistry;

	public void init() throws Exception {
		rpcRegistry.run();
	}
}
