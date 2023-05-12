package com.tupelo.rpc.discover;

import com.alibaba.fastjson.JSON;
import com.tupelo.rpc.data.RegistryInfo;
import com.tupelo.rpc.property.RpcProperty;
import com.tupelo.rpc.zk.ServerZk;
import com.tupelo.rpc.zk.ServiceProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @Author: caichuang
 * @Date: 2023/5/12 10:54
 */
@Component
@Slf4j
public class ZkDiscover {

	/**
	 * 客户端先拉取zk数据
	 */
	@Autowired
	private ServerZk serverZk;


	public void discover() throws Exception {
		List<String> serviceList = serverZk.getServiceList();
		log.info("获取到的节点信息 {}", JSON.toJSONString(serviceList));
		if(CollectionUtils.isEmpty(serviceList)){
			return;
		}
		for (String s : serviceList) {
			serverZk.subscribeZKEvent(s);
			List<ServiceProvider> serviceInfos = serverZk.getServiceInfos(s);
			// 将信息保存在全局对象中
			RegistryInfo.registryMap.put(s,serviceInfos);
		}
	}
}
