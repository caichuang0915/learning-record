package com.tupelo.rpc.data;

import lombok.Data;

/**
 * @Author: caichuang
 * @Date: 2023/5/12 10:11
 */
@Data
public class RpcResponse {

	private String requestId;
	private Object result;
	private Throwable cause;
}
