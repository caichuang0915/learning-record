package com.tupelo.design;

/**
 * @Author: caichuang
 * @Date: 2023/2/6 11:00
 */
public class Singleton {

	private static Singleton singleton;

	private Singleton(){}

	public Singleton init(){

		if(null==singleton){
			synchronized (Singleton.class){
				singleton = new Singleton();
			}
		}
		return singleton;

	}
}
