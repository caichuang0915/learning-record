package com.tupelo.thread;

/**
 * @Author: caichuang
 * @Date: 2023/2/6 10:39
 */
public class DeadLock {

	public static void main(String[] args) {

		ObjectA objectA = new ObjectA();
		ObjectB objectB = new ObjectB();


		Thread threadA = new Thread(new Runnable() {
			@Override
			public void run() {

				synchronized (objectA){


					System.out.println("threadA running === ");
					synchronized (objectB){


						System.out.println("threadB running second=== ");


					}

				}

			}
		});


		Thread threadB = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (objectB){


					System.out.println("threadB running === ");

					synchronized (objectA){


						System.out.println("threadA running second === ");

					}
				}
			}
		});


		threadA.start();
		threadB.start();


	}



}


class ObjectA{

}

class ObjectB{

}