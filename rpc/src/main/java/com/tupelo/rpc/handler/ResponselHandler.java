package com.tupelo.rpc.handler;

import com.alibaba.fastjson.JSON;
import com.tupelo.rpc.data.RegistryInfo;
import com.tupelo.rpc.data.RpcRequest;
import com.tupelo.rpc.data.RpcResponse;
import com.tupelo.rpc.util.SpringBeanUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.DefaultPromise;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * @Author: caichuang
 * @Date: 2023/5/12 9:52
 */
@Slf4j
@ChannelHandler.Sharable
public class ResponselHandler extends SimpleChannelInboundHandler<RpcResponse> {


	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, RpcResponse rpcResponse) throws Exception {

		log.info("接受到返回数据 {}", JSON.toJSONString(rpcResponse));

		DefaultPromise defaultPromise = RegistryInfo.promiseMap.get(rpcResponse.getRequestId());
		if(null!=defaultPromise){
			defaultPromise.setSuccess(rpcResponse);
		}

	}
}
