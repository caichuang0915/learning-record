package com.tupelo.rpc.codec;

import com.tupelo.rpc.data.RpcRequest;
import com.tupelo.rpc.data.RpcResponse;
import com.tupelo.rpc.util.ProtostuffUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * @Author: caichuang
 * @Date: 2023/5/12 10:05
 */
public class SecondDec extends MessageToMessageDecoder<ByteBuf> {


	@Override
	protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {

		System.out.println("SecondDec =======");
		int len = byteBuf.readableBytes();
		byte[] data = new byte[len];
		byteBuf.readBytes(data);
		RpcRequest rpcRequest = ProtostuffUtil.deserialize(data, RpcRequest.class);
		list.add(rpcRequest);

	}
}
