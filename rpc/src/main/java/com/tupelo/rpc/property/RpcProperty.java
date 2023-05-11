package com.tupelo.rpc.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: caichuang
 * @Date: 2022/7/29 15:07
 */
@Data
@Component
@ConfigurationProperties(prefix = "rpc")
public class RpcProperty {


	private Integer port;
	private String root;
	public Curator curator;


	@Data
	public static class Curator{
		private int retryCount;
		private int elapsedTimeMs;
		private String connectString;
		private int sessionTimeoutMs;
		private int connectionTimeoutMs;
	}

}
