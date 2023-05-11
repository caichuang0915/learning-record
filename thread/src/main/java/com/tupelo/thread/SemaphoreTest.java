package com.tupelo.thread;

import java.util.concurrent.*;

/**
 * @Author: caichuang
 * @Date: 2023/2/7 17:45
 */
public class SemaphoreTest {


	public static void main(String[] args) throws InterruptedException {
		Semaphore semaphore = new Semaphore(10);
		ExecutorService threadPool = Executors.newFixedThreadPool(20);

		for (int i = 0; i < 100; i++) {
			final int threadnum = i;
			threadPool.execute(() -> {// Lambda 表达式的运用
				try {
					semaphore.acquire();// 获取一个许可，所以可运行线程数量为
					test(threadnum);
					semaphore.release();// 释放一个许可
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			});
		}
		System.out.println("end");
	}

	public static void test(int threadnum) throws InterruptedException {
		System.out.println("threadnum:" + threadnum);
	}

}
