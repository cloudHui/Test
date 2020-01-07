package com.sc.test.curr;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * * @author Cloud Liu
 * 
 * @date create time :2017年12月3日 下午2:49:28
 * @version 1.0
 */

/**
 * Semaphore
 * 
 * @author Cloud Liu 信号灯 用于线程互斥只有拥有信号的线程可以执行
 */
public class SemaphoreTest {

	public static void main(String[] args) {
		ExecutorService eService = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(3);
		for (int i = 0; i < 11; i++) {
			new Thread(new Runnable() {

				public void run() {
					try {
						semaphore.acquire();
						Thread.sleep(1000);
						System.out.println("Thread name" + Thread.currentThread().getName()
								+ "  the using semaphore number : " + (3 - semaphore.availablePermits()));
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						semaphore.release();
					}
				}
			}).start();
		}
		eService.shutdown();
	}

}
