package com.sc.test.curr;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * * @author Cloud Liu
 * 
 * @date create time :2017年12月3日 下午3:18:59
 * @version 1.0
 */
/**
 * 
 * @author Administrator 循环使用障碍
 */
public class CyclicBarrierTest {

	public static void main(String[] args) {
		ExecutorService eService = Executors.newCachedThreadPool();
		final CyclicBarrier cBarrier = new CyclicBarrier(3);
		for (int i = 0; i < 3; i++) {
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						Thread.sleep(new Random().nextInt(3) * 1000);
						System.out.println(Thread.currentThread().getName() + "place one there is "
								+ (cBarrier.getNumberWaiting() + 1) + " thread in "
								+ ((cBarrier.getNumberWaiting() + 1) == 3 ? "go on" : " keep waiting"));
						cBarrier.await();
						Thread.sleep(new Random().nextInt(3) * 1000);
						System.out.println(Thread.currentThread().getName() + "place two there is "
								+ (cBarrier.getNumberWaiting() + 1) + " thread in "
								+ ((cBarrier.getNumberWaiting() + 1) == 3 ? "go on" : " keep waiting"));
						cBarrier.await();
						Thread.sleep(new Random().nextInt(3) * 1000);
						System.out.println(Thread.currentThread().getName() + "place three there is "
								+ (cBarrier.getNumberWaiting() + 1) + " thread in "
								+ ((cBarrier.getNumberWaiting() + 1) == 3 ? "go on" : " keep waiting"));
						cBarrier.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			eService.execute(runnable);
		}
		eService.shutdown();
	}
}
