package com.tupelo.rpc.registry;

import com.tupelo.rpc.property.RpcProperty;
import com.tupelo.rpc.util.SpringBeanUtil;
import com.tupelo.rpc.zk.ServerZk;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: caichuang
 * @Date: 2023/5/11 17:43
 */
@Component
@Slf4j
public class ZkRegistry {


	@Autowired
	private ServerZk serverZk;
	@Autowired
	private RpcProperty rpcProperty;


	public void serviceRegistry() throws Exception {
		// 获取服务中所有的 RegistryAnno 标注的类
		Map<String, Object> beansByAnno = SpringBeanUtil.getBeansByAnno(RegistryAnno.class);
		if(beansByAnno.isEmpty()){
			log.info("无需要注册的服务");
			return;
		}
		// 创建根节点
		serverZk.createRootIfNotExist();
		String ip = "127.0.0.1";
		for (Map.Entry<String, Object> entry : beansByAnno.entrySet()) {
			Object bean = entry.getValue();
			RegistryAnno annotation = bean.getClass().getAnnotation(RegistryAnno.class);
			Class<?> aClass = annotation.interfaceClass();
			// 创建接口节点
			serverZk.createIfNotExistPre(aClass.getName());
			// 创建提供者信息节点
			String node = aClass.getName() + "/" + ip + ":" + rpcProperty.getPort();
			serverZk.createIfNotExist(node);
			log.info("{}服务注册成功 提供者为 {}",aClass.getName(),node);
		}
	}

}
