package com.tupelo.dubbo.provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.tupelo.dubbo.service.ProviderService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.RpcException;

/**
 * @Author: caichuang
 * @Date: 2022/10/13 9:39
 */
@DubboService(
		methods = {
				@Method(
						name = "doMain"
				)
		}
)
public class ProviderServiceImpl implements ProviderService {

	@Override
	public String doMain(Integer m) {

		if(m==2){
			throw new RpcException("happen rpc exception");
		}

		if(m==3){
			int oii = 1/0;
		}

		RpcContext context = RpcContext.getContext();
		String remoteHost = context.getRemoteHost();

		Object mm = context.getAttachment("mm");
		System.out.println(JSON.toJSONString(context));
		System.out.println(remoteHost);
		System.out.println(mm);
		String message = "do main m = " + m;
		System.out.println(message);
		return message;
	}
}
