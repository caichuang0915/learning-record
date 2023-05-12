package com.tupelo.rpc.codec;

import com.tupelo.rpc.data.RpcRequest;
import com.tupelo.rpc.data.RpcResponse;
import com.tupelo.rpc.util.ProtostuffUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @Author: caichuang
 * @Date: 2023/5/12 10:05
 */
public class SecondEncResp extends MessageToMessageEncoder<RpcRequest> {


	@Override
	protected void encode(ChannelHandlerContext channelHandlerContext, RpcRequest rpcResponse, List<Object> list) throws Exception {
		System.out.println("FirstEnc==========");
		byte[] serialize = ProtostuffUtil.serialize(rpcResponse);
		ByteBuf byteBuf = channelHandlerContext.alloc().buffer(serialize.length).writeBytes(serialize);
		list.add(byteBuf);

	}
}
