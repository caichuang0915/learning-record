package com.tupelo.rpc.data;

import lombok.Data;

/**
 * @Author: caichuang
 * @Date: 2023/5/12 10:11
 */
@Data
public class RpcRequest {

	private String requestId;
	private String className;
	private String methodName;
	private Class<?>[] parameterTypes;
	private Object[] parameters;
}
