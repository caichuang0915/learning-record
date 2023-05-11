package com.tupelo.spring.doimport;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: caichuang
 * @Date: 2023/4/14 15:58
 */
public class MyListener implements ApplicationListener {
	@Override
	public void onApplicationEvent(ApplicationEvent event) {

	}
	static Integer i = 0;
	static int j = 0;
	public static void main(String[] args) {



		for (int i1 = 0; i1 < 100000; i1++) {
			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {

//					add(j);
					j++;
//					i++;
					System.out.println(j);

				}
			});

			thread.start();

		}
		System.out.println(i);
		System.out.println(j);

	}

	public static synchronized void add(int j){
		j++;
	}
}
