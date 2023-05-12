package com.tupelo.rpc;

import com.tupelo.rpc.discover.RpcDiscover;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @Author: caichuang
 * @Date: 2023/5/11 18:11
 * 客户端
 */
@Configuration
public class RpcClientBootStrap {


	@Resource
	private RpcDiscover rpcDiscover;

	public void init() throws Exception {
		rpcDiscover.run();
	}
}
