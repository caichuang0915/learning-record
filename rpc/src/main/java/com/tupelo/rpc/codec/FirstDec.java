package com.tupelo.rpc.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * @Author: caichuang
 * @Date: 2023/5/12 10:05
 */
public class FirstDec extends LengthFieldBasedFrameDecoder {

	public FirstDec() {
		super(Integer.MAX_VALUE,0, 4, 0, 4);
	}

	@Override
	protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
		return super.decode(ctx, in);
	}
}
