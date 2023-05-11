package com.tupelo.rpc.zk;

import com.tupelo.rpc.property.RpcProperty;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: caichuang
 * @Date: 2022/7/29 15:00
 */
@Component
public class ServerZk {


	@Autowired
	private CuratorFramework curatorFramework;

	@Autowired
	private RpcProperty rpcProperty;

	@PostConstruct
	public void init(){
		curatorFramework.start();
	}


	/**
	 * 创建节点
	 */
	public void createNode() {


	}


	/**
	 * 获取节点
	 */
	public void getData() {

	}

	public void createRootIfNotExist() throws Exception {
		Stat stat = curatorFramework.checkExists().forPath(rpcProperty.getRoot());
		if(null==stat){
			curatorFramework.create().withMode(CreateMode.PERSISTENT).forPath(rpcProperty.getRoot());
		}
	}


	public void createIfNotExist(String path) throws Exception {
		String node = rpcProperty.getRoot() + path;
		Stat stat = curatorFramework.checkExists().forPath(node);
		if(null==stat){
			curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(node);
		}
	}




}
