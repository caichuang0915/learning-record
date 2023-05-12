package com.tupelo.rpc.registry;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: caichuang
 * @Date: 2023/5/11 17:43
 */
@Component
public class RpcRegistry {

	@Resource
	private ZkRegistry zkRegistry;

	@Resource
	private RpcServer rpcServer;

	// 服务注册
	public void run() throws Exception {
		zkRegistry.serviceRegistry();

		// 启动netty服务
		rpcServer.start();

	}

}
