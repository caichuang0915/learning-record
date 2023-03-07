package com.tupelo.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: caichuang
 * @Date: 2023/2/7 16:15
 */
public class Cas {


	public static void main(String[] args) {

		AtomicInteger atomicInteger = new AtomicInteger(1);

		atomicInteger.compareAndSet(2,3);

		System.out.println(atomicInteger);

		atomicInteger.compareAndSet(1,3);

		System.out.println(atomicInteger);


	}
}
