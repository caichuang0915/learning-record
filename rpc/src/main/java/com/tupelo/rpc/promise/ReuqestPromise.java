package com.tupelo.rpc.promise;

import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;

/**
 * @Author: caichuang
 * @Date: 2023/5/12 16:20
 */
public class ReuqestPromise extends DefaultPromise {

	public ReuqestPromise(EventExecutor executor) {
		super(executor);
	}
}
