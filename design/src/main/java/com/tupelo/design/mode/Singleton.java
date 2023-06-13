package com.tupelo.design.mode;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: caichuang
 * @Date: 2023/2/6 11:00
 */
public class Singleton {
	private static Singleton singleton;

	private Singleton(){}

	public static Singleton getInstance(){

		if(null==singleton){
			synchronized (Singleton.class){
				if(null==singleton){
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}
