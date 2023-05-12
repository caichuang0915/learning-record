package com.tupelo.rpc.handler;

import com.alibaba.fastjson.JSON;
import com.tupelo.rpc.data.RpcRequest;
import com.tupelo.rpc.data.RpcResponse;
import com.tupelo.rpc.util.SpringBeanUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * @Author: caichuang
 * @Date: 2023/5/12 9:52
 */
@Slf4j
@ChannelHandler.Sharable
public class RequestChannelHandler extends SimpleChannelInboundHandler<RpcRequest> {


	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, RpcRequest rpcRequest) throws Exception {

		log.info("接受到请求 {}", JSON.toJSONString(rpcRequest));

		RpcResponse rpcResponse = new RpcResponse();
		rpcResponse.setRequestId(rpcRequest.getRequestId());

		String className = rpcRequest.getClassName();
		String methodName = rpcRequest.getMethodName();
		Class<?>[] parameterTypes = rpcRequest.getParameterTypes();
		Object[] parameters = rpcRequest.getParameters();

		Object bean = SpringBeanUtil.getBean(Class.forName(className));
		Method method = bean.getClass().getMethod(methodName, parameterTypes);
		Object invoke = method.invoke(bean, parameters);
		rpcResponse.setResult(invoke);

		channelHandlerContext.writeAndFlush(rpcResponse);

	}
}
