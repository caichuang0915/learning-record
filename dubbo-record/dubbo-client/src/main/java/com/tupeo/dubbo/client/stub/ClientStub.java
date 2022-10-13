package com.tupeo.dubbo.client.stub;

import com.tupelo.dubbo.service.ProviderService;
import org.apache.dubbo.rpc.RpcException;

/**
 * @Author: 本地存根
 * @Date: 2022/10/13 9:39
 */
public class ClientStub implements ProviderService {

	private ProviderService providerService;

	public ClientStub(ProviderService providerService) {
		this.providerService = providerService;
	}

	@Override
	public String doMain(Integer m) {

		System.out.println("stub start ===========");
		String result = providerService.doMain(m);
		System.out.println("stub end ===========");
		return result;
	}
}
