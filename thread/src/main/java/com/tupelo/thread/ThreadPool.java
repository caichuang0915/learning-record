package com.tupelo.thread;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: caichuang
 * @Date: 2023/2/6 14:54
 */
public class ThreadPool {

	public static void main(String[] args) {

		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(1);
		threadPoolTaskExecutor.setMaxPoolSize(1);
		threadPoolTaskExecutor.setQueueCapacity(1);
		threadPoolTaskExecutor.setRejectedExecutionHandler(new CustonRejectedExecutionHandler());
		threadPoolTaskExecutor.initialize();


		threadPoolTaskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("1 thread ..");
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("1 thread end..");
			}
		});

		threadPoolTaskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("2 thread ..");
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("2 thread end..");
			}
		});

		threadPoolTaskExecutor.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("3 thread ..");
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("3 thread end..");
				return "3333";
			}
		});

	}
}

class CustonRejectedExecutionHandler implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

		System.out.println("reject");
	}
}
