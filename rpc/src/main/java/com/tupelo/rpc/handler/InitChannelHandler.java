package com.tupelo.rpc.handler;

import com.tupelo.rpc.codec.FirstDec;
import com.tupelo.rpc.codec.FirstEnc;
import com.tupelo.rpc.codec.SecondDec;
import com.tupelo.rpc.codec.SecondEnc;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * @Author: caichuang
 * @Date: 2023/5/12 9:52
 */
public class InitChannelHandler extends ChannelInitializer<SocketChannel> {

	private EventExecutorGroup business;

	public InitChannelHandler(EventExecutorGroup business) {
		this.business = business;
	}

	// service head 在出去方向

	/**
	 * handler head在出去方向，tail在进入方向
	 * 如 ： server head在client方向，tail在自己方向
	 * 		client head在server方向，tail在自己方向
	 *
	 *
	 * 	server端
	 *
	 * <---------------client 请求 server 的顺序的方向------------------------------------------------
	 *
	 * tail -------requestHandler-------secondDec----firstDec---------firstEnc-----SecondEnc------>  head
	 *
	 * ---------------server 返回 client 的顺序的方向------------------------------------------------>
	 *
	 *
	 *
	 */

	@Override
	protected void initChannel(SocketChannel socketChannel) throws Exception {

		ChannelPipeline pipeline = socketChannel.pipeline();
		// 返回数据二次编码
		pipeline.addLast("SecondEnc",new SecondEnc());
		pipeline.addLast("firstEnc",new FirstEnc());

		// 接受到数据一次解码
		pipeline.addLast("firstDec",new FirstDec());
		pipeline.addLast("secondDec",new SecondDec());

		// 处理请求
		pipeline.addLast(business,"request",new RequestChannelHandler());

	}
}
