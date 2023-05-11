package com.tupelo.thread;

import jdk.nashorn.internal.ir.Block;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCondition {

    public static Lock lock = new ReentrantLock();


    public static void main(String[] args) throws InterruptedException {



        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();


        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executorService.execute(new ThreadRun(conditionA,conditionB));
            executorService.execute(new ThreadRun(conditionB,conditionC));
            executorService.execute(new ThreadRun(conditionC,conditionA));
        }


        Thread.sleep(1000L);

        lock.lock();
        conditionA.signal();
        lock.unlock();




    }

    public static class ThreadRun implements Runnable{

        private Condition self;
        private Condition other;

        public ThreadRun(Condition self, Condition other) {
            this.self = self;
            this.other = other;
        }

        @Override
        public void run() {
            lock.lock();

            try {

                self.await();

                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000L);

                other.signal();


            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }


}