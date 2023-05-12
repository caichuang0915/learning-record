package com.tupelo.rpc.data;

import com.tupelo.rpc.zk.ServiceProvider;
import io.netty.util.concurrent.DefaultPromise;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: caichuang
 * @Date: 2023/5/12 10:11
 */
@Data
public class RegistryInfo {


	public static Map<String, List<ServiceProvider>> registryMap = new HashMap<>();

	public static Map<String, DefaultPromise> promiseMap = new HashMap<>();

}
