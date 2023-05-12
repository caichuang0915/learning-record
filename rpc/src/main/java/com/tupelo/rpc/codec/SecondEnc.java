package com.tupelo.rpc.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldPrepender;

import java.util.List;

/**
 * @Author: caichuang
 * @Date: 2023/5/12 10:05
 */
public class SecondEnc extends LengthFieldPrepender {


	public SecondEnc() {
		super(4);
	}

	@Override
	protected void encode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
		System.out.println("encode1111111");
		super.encode(ctx, msg, out);
	}
}
