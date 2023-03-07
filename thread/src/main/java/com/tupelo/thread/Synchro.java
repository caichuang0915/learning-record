package com.tupelo.thread;

/**
 * @Author: caichuang
 * @Date: 2023/2/6 11:08
 */
public class Synchro {

	public static void methodStatic(){
		System.out.println("I am static");
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void methodA(){
		System.out.println("I am A");
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void methodB(){
		System.out.println("I am B");

		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Synchro synchro = new Synchro();


		Thread threadA = new Thread(new Runnable() {
			@Override
			public void run() {
				synchro.methodA();
			}
		});


		Thread threadB = new Thread(new Runnable() {
			@Override
			public void run() {
				synchro.methodB();
			}
		});

		Thread threadC = new Thread(new Runnable() {
			@Override
			public void run() {
				Synchro.methodStatic();
			}
		});



		threadA.start();
		threadB.start();
		threadC.start();
	}



}
