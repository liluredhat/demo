package com.hnisi.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LockTest {

	public void test1(){
		synchronized (this) {
			try {
				Thread.sleep(10 * 1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() +":enter...");
		}
	}
	
	public synchronized void test2(){
		System.out.println("enter...");
	}
	
	public static void main(String[] args) {
		LockTest test = new LockTest();
		Runnable task = new Runnable() {
			@Override
			public void run() {
				test.test1();
			}
		};
		//2个线程
		//new Thread(task).start();
		//new Thread(task).start();
		//使用jdk线程池
		ExecutorService executor = Executors.newCachedThreadPool();
		//executor.execute(task);
		executor = Executors.newFixedThreadPool(1);
		executor.execute(task);
	}
}
