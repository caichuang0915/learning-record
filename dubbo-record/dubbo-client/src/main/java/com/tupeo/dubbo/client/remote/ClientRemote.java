package com.tupeo.dubbo.client.remote;

import com.tupelo.dubbo.service.ProviderService;

/**
 * @Author: 本地伪装
 * @Date: 2022/10/13 9:39
 */
public class ClientRemote implements ProviderService {

	@Override
	public String doMain(Integer m) {
		return "remote result";
	}
}
