package com.tupelo.rpc.registry;

import com.tupelo.rpc.RpcClientBootStrap;
import com.tupelo.rpc.handler.InitChannelHandler;
import com.tupelo.rpc.handler.MainChannelHandler;
import com.tupelo.rpc.property.RpcProperty;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.NettyRuntime;
import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.EventExecutorGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: caichuang
 * @Date: 2023/5/12 9:43
 */
@Service
@Slf4j
public class NetServer implements RpcServer{

	@Autowired
	private RpcProperty rpcProperty;

	@Resource
	private RpcClientBootStrap rpcClientBootStrap;

	@Override
	public void start() {


		EventLoopGroup boss = new NioEventLoopGroup(1,new DefaultThreadFactory("boss"));
		EventLoopGroup worker = new NioEventLoopGroup(0,new DefaultThreadFactory("worker"));

		EventExecutorGroup business = new NioEventLoopGroup(NettyRuntime.availableProcessors() * 2,new DefaultThreadFactory("business"));


		try {
			ServerBootstrap bootstrap  = new ServerBootstrap();
			bootstrap.group(boss,worker).channel(NioServerSocketChannel.class)
					.option(ChannelOption.SO_BACKLOG,1024)
					.option(ChannelOption.TCP_NODELAY,true)
					.option(ChannelOption.SO_KEEPALIVE,true)
					.childHandler(new InitChannelHandler(business))
//					.childHandler(new MainChannelHandler())
			;

			ChannelFuture future = bootstrap.bind(rpcProperty.getPort()).syncUninterruptibly();

			log.info("netty server 启动成功");

			rpcClientBootStrap.init();

			future.channel().closeFuture().syncUninterruptibly();
		} catch (InterruptedException e) {
			log.error("",e);
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			boss.shutdownGracefully();
			worker.shutdownGracefully();
			business.shutdownGracefully();
		}


	}
}
