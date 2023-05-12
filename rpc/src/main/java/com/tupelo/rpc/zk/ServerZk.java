package com.tupelo.rpc.zk;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.tupelo.rpc.property.RpcProperty;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: caichuang
 * @Date: 2022/7/29 15:00
 */
@Component
@Slf4j
public class ServerZk {


	@Autowired
	private CuratorFramework curatorFramework;

	@Autowired
	private RpcProperty rpcProperty;

	@PostConstruct
	public void init(){
		curatorFramework.start();
	}

	public void createRootIfNotExist() throws Exception {
		Stat stat = curatorFramework.checkExists().forPath(rpcProperty.getRoot());
		if(null==stat){
			curatorFramework.create().withMode(CreateMode.PERSISTENT).forPath(rpcProperty.getRoot());
		}
	}


	public void createIfNotExistPre(String path) throws Exception {
		String node = rpcProperty.getRoot() + "/" + path;
		Stat stat = curatorFramework.checkExists().forPath(node);
		if(null==stat){
			curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(node);
		}
	}


	public void createIfNotExist(String path) throws Exception {
		String node = rpcProperty.getRoot() + "/" + path;
		Stat stat = curatorFramework.checkExists().forPath(node);
		if(null==stat){
			curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(node);
		}
	}


	/**
	 * 获取所有服务列表：所有的服务接口信息
	 * @return
	 */
	public List<String> getServiceList() throws Exception {
		String path = rpcProperty.getRoot();
		return curatorFramework.getChildren().forPath(path);
	}


	/**
	 *  根据服务名称获取服务节点完整信息
	 * @param serviceName
	 * @return
	 */
	public List<ServiceProvider> getServiceInfos(String serviceName) throws Exception {
		String path = rpcProperty.getRoot() + "/" + serviceName;
		List<String> children = curatorFramework.getChildren().forPath(path);
		List<ServiceProvider> providerServices = convertToProviderService(serviceName,children);
		return providerServices;
	}

	/**
	 * 将拉取的服务节点信息转换为服务记录对象
	 *
	 * @param serviceName
	 * @param list
	 * @return
	 */
	private List<ServiceProvider> convertToProviderService(String serviceName, List<String> list) {
		if (CollectionUtils.isEmpty(list)) {
			return Lists.newArrayListWithCapacity(0);
		}
		// 将服务节点信息转换为服务记录对象
		List<ServiceProvider> providerServices = list.stream().map(v -> {
			String[] serviceInfos = v.split(":");
			return ServiceProvider.builder()
					.serviceName(serviceName)
					.serverIp(serviceInfos[0])
					.rpcPort(Integer.parseInt(serviceInfos[1]))
					.build();
		}).collect(Collectors.toList());
		return providerServices;
	}

	/**
	 * 服务订阅接口
	 * @param serviceName
	 */
	public void subscribeZKEvent(String serviceName) throws Exception {
		// 1. 组装服务节点信息
		String path = rpcProperty.getRoot() + "/" + serviceName;
		// 2. 订阅服务节点（监听节点变化）

		byte[] bytes = curatorFramework.getData().usingWatcher(new Watcher() {
			@Override
			public void process(WatchedEvent watchedEvent) {

				log.info("节点变化 {}", JSON.toJSONString(watchedEvent));
			}
		}).forPath(path);
		log.info("监听到节点的变化{}",new String(bytes));


	}




}
