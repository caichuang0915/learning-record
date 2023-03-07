package com.tupelo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: caichuang
 * @Date: 2023/2/6 14:38
 */
public class RunableAndCallable {


	public static void main(String[] args) {

		ObjectA1 objectA1 = new ObjectA1();
		ObjectB1 objectB1 = new ObjectB1();




		Thread threadA = new Thread(objectA1);


		FutureTask<String> threadB = new FutureTask<>(objectB1);


		Thread threadB1 = new Thread(threadB);
		System.out.println("main running");

		threadA.start();
		threadB1.start();

		String s = null;
		try {
			s = threadB.get();
		} catch (Exception e) {
			System.out.println("callable error");
		}
		System.out.println("callback end " + s);
		System.out.println("main running end");
	}

}



class ObjectA1 implements Runnable{

	@Override
	public void run() {

		System.out.println("Runnable running");
		int a = 1/0;

	}
}

class ObjectB1 implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("callable running");


		Thread.sleep(2000L);

		int a = 1/0;
		return "I am Runable";
	}
}