package com.tupelo.rpc.discover;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: caichuang
 * @Date: 2023/5/12 10:54
 */
@Component
@Slf4j
public class RpcDiscover {

	/**
	 * 客户端先拉取zk数据
	 *
	 */

	@Resource
	private ZkDiscover zkDiscover;


	public void run() throws Exception {


		zkDiscover.discover();

		log.info("netty client 客户端启动成功");

	}
}
