package com.tupelo.thread;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author: caichuang - 锁升级
 * @Date: 2023/2/7 15:25
 */
public class LockUp {


	public static void lock(Monitor monitor){
		synchronized (monitor){
			System.out.println(ClassLayout.parseInstance(monitor).toPrintable());
		}
	}


	public static void main(String[] args) throws InterruptedException {

		Thread.sleep(5000L);

		Monitor monitor = new Monitor();


		System.out.println(ClassLayout.parseInstance(monitor).toPrintable());


//		int i = monitor.hashCode();
//
//		System.out.println(ClassLayout.parseInstance(monitor).toPrintable());

		synchronized (monitor){
			System.out.println("偏向锁");
			System.out.println(ClassLayout.parseInstance(monitor).toPrintable());
//			Thread.sleep(2000L);
//			System.out.println("有竞争");
//			System.out.println(ClassLayout.parseInstance(monitor).toPrintable());
		}

		System.out.println("=======");
		System.out.println(ClassLayout.parseInstance(monitor).toPrintable());


		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (monitor){
					System.out.println("抢夺锁 成功 =====");
					System.out.println(ClassLayout.parseInstance(monitor).toPrintable());
				}
			}
		});
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (monitor){
					System.out.println("抢夺锁 成功 =====");
					System.out.println(ClassLayout.parseInstance(monitor).toPrintable());
				}
			}
		});
//		Thread thread2 = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				synchronized (monitor){
//					System.out.println("抢夺锁 成功 =====");
//					System.out.println(ClassLayout.parseInstance(monitor).toPrintable());
//				}
//			}
//		});
		thread.start();
//		thread1.start();
//		thread2.start();
	}
}


class Monitor{

}
