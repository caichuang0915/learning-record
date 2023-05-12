package com.tupelo.rpc.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * @Author: caichuang
 * @Date: 2023/5/12 9:52
 */
public class MainChannelHandler implements ChannelHandler {

	@Override
	public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {

		System.out.println("handlerAdded");

	}

	@Override
	public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
		System.out.println("handlerRemoved");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {
		System.out.println("exceptionCaught");
	}
}
