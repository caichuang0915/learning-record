package com.tupelo.rpc.request;

import com.tupelo.rpc.codec.FirstDec;
import com.tupelo.rpc.codec.FirstDecResp;
import com.tupelo.rpc.codec.SecondEnc;
import com.tupelo.rpc.codec.SecondEncResp;
import com.tupelo.rpc.data.RegistryInfo;
import com.tupelo.rpc.data.RpcRequest;
import com.tupelo.rpc.data.RpcResponse;
import com.tupelo.rpc.handler.ResponselHandler;
import com.tupelo.rpc.zk.ServiceProvider;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.DefaultThreadFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @Author: caichuang
 * @Date: 2023/5/12 15:39
 */
@Component
public class RequestManage {


	public RpcResponse sendRequest(RpcRequest rpcRequest) throws Exception {
		List<ServiceProvider> serviceProviders = RegistryInfo.registryMap.get(rpcRequest.getClassName());
		if(CollectionUtils.isEmpty(serviceProviders)){
			throw new Exception();
		}
		ServiceProvider serviceProvider = serviceProviders.get(0);
		return nettySend(serviceProvider, rpcRequest);
	}


	private RpcResponse nettySend(ServiceProvider serviceProvider,RpcRequest rpcRequest) throws InterruptedException, ExecutionException {

		EventLoopGroup eventLoopGroup = new NioEventLoopGroup(0,new DefaultThreadFactory("client"));
		Bootstrap bootstrap = new Bootstrap();
		ResponselHandler responselHandler = new ResponselHandler();

		bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
				.handler(new ChannelInitializer<SocketChannel>(){

					@Override
					protected void initChannel(SocketChannel channel) throws Exception {
						ChannelPipeline pipeline = channel.pipeline();


						pipeline.addLast("secondtEnc1",new SecondEnc());
						pipeline.addLast("firstEnc1",new SecondEncResp());

						pipeline.addLast("secondDec1",new FirstDec());
						pipeline.addLast("firstDec1",new FirstDecResp());

						pipeline.addLast("hannler1",responselHandler);

					}
				});
		ChannelFuture future = bootstrap.connect(serviceProvider.getServerIp(), serviceProvider.getRpcPort()).sync();
		if(future.isSuccess()){

			Channel channel = future.channel();

			DefaultPromise defaultPromise = new DefaultPromise(channel.eventLoop());

			RegistryInfo.promiseMap.put(rpcRequest.getRequestId(),defaultPromise);

			channel.writeAndFlush(rpcRequest);

			RpcResponse rpcResponse = (RpcResponse) defaultPromise.get();

			return rpcResponse;

		}

		return new RpcResponse();

	}
}
