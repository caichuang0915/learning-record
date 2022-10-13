package com.tupeo.dubbo.client.controller;

import com.tupelo.dubbo.service.ProviderService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: caichuang
 * @Date: 2022/10/12 17:53
 */
@RestController
public class ConsumerController {

	@DubboReference(
			check = false,
			methods = {
					@Method(
							name = "doMain"
					)
			},
			stub = "com.tupeo.dubbo.client.stub.ClientStub",
			mock = "com.tupeo.dubbo.client.remote.ClientRemote"
	)
	private ProviderService providerService;

	@GetMapping("/doSend/{m}")
	public String doConsumer(@PathVariable Integer m){

		RpcContext context = RpcContext.getContext();
		context.setAttachment("mm","beauty");

		return providerService.doMain(m);
	}

}
