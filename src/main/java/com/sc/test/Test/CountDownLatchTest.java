package com.sc.test.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * * @author Cloud Liu
 * 
 * @date create time :2017年12月3日 下午3:56:17
 * @version 1.0
 */
/**
 * 
 * @author Administrator countdownlatch 线程同步类似于 condition lock.newcondition
 */
public class CountDownLatchTest {

	public static void main(String[] args) {
		ExecutorService eService = Executors.newCachedThreadPool();
		final CountDownLatch cdOrder = new CountDownLatch(1);
		final CountDownLatch cdAnwser = new CountDownLatch(3);
		Runnable runnable = new Runnable() {
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName() + " is waiting for order ");
					cdOrder.await();
					Thread.sleep(2000);
					System.out.println(Thread.currentThread().getName() + " is working for anwser ");
					Thread.sleep(2000);
					cdAnwser.countDown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		for (int i = 0; i < 3; i++) {
			eService.execute(runnable);
		}
		eService.shutdown();

		try {
			Thread.sleep(2000);
			System.out.println(" +++++++++++ i am ordering");
			cdOrder.countDown();
			// Thread.sleep(3000);
			System.out.println("main is waiting for anwser:");
			cdAnwser.await();
			System.out.println("recived anwser");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
