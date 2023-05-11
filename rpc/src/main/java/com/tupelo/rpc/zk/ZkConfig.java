package com.tupelo.rpc.zk;

import com.tupelo.rpc.property.RpcProperty;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: caichuang
 * @Date: 2022/7/29 15:09
 */
@Configuration
public class ZkConfig {

	@Autowired
	private RpcProperty rpcProperty;


	@Bean
	public CuratorFramework curatorFramework() {
		RpcProperty.Curator zkProperty = rpcProperty.getCurator();
		return CuratorFrameworkFactory.newClient(
				zkProperty.getConnectString(),
				zkProperty.getSessionTimeoutMs(),
				zkProperty.getConnectionTimeoutMs(),
				new RetryNTimes(zkProperty.getRetryCount(), zkProperty.getElapsedTimeMs()));
	}

}
