package com.tupelo.rpc.proxy;


import com.tupelo.rpc.data.RpcRequest;
import com.tupelo.rpc.data.RpcResponse;
import com.tupelo.rpc.request.RequestManage;
import com.tupelo.rpc.util.SpringBeanUtil;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * @Author: caichuang
 * @Date: 2023/5/12 15:16
 */
@Component
public class RequestProxy implements MethodInterceptor {


	public <T> T createProxyObject(Class<T> clazz) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return (T)enhancer.create();
	}


	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

		if(ReflectionUtils.isObjectMethod(method)){
			return method.invoke(method.getDeclaringClass().newInstance(),objects);
		}

		RpcRequest rpcRequest = new RpcRequest();

		rpcRequest.setRequestId(UUID.randomUUID().toString());
		rpcRequest.setMethodName(method.getDeclaringClass().getName());
		rpcRequest.setClassName(method.getDeclaringClass().getName());
		rpcRequest.setMethodName(method.getName());
		rpcRequest.setParameterTypes(method.getParameterTypes());
		rpcRequest.setParameters(objects);

		// 发送请求

		RequestManage requestManage = SpringBeanUtil.getBean(RequestManage.class);
		RpcResponse rpcResponse = requestManage.sendRequest(rpcRequest);

		if(null==rpcResponse){
			return null;
		}

		return rpcResponse.getResult();
	}


}
