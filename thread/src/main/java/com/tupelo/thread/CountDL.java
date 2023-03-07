package com.tupelo.thread;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: caichuang
 * @Date: 2023/2/7 17:45
 */
public class CountDL {


	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(2);

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("111111111111");
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				countDownLatch.countDown();
				try {
					countDownLatch.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("111111111111111==========");
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("2222222");
				try {
					Thread.sleep(3000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				countDownLatch.countDown();

				try {
					countDownLatch.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("2222222========");
			}
		});

		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("3333333333");
				try {
					Thread.sleep(3000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				countDownLatch.countDown();
				try {
					countDownLatch.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("33333333333========");
			}
		});

//		thread1.start();
//		thread2.start();
//		thread3.start();
//
//		Thread.sleep(2000L);
//
//		countDownLatch.countDown();
//		countDownLatch.countDown();
//		countDownLatch.countDown();

		CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

		Thread thread11 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("111111111111");
				try {
					try {
						cyclicBarrier.await();
					} catch (BrokenBarrierException e) {
						e.printStackTrace();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("111111111111111==========");
			}
		});

		Thread thread21 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("2222222");
				try {
					try {
						cyclicBarrier.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
				System.out.println("2222222========");
			}
		});

		Thread thread31 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("3333333");
				try {
					try {
						cyclicBarrier.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
				System.out.println("333333========");
			}
		});


		thread11.start();
		thread21.start();
		thread31.start();




	}
}
