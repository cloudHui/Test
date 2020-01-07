package com.sc.test.curr;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * * @author Cloud Liu
 * 
 * @date create time :2017年12月3日 下午4:29:54
 * @version 1.0
 */
/**
 * 线程数据交换
 * 
 * @author Administrator
 *
 */
public class ExchangerTest {

	public static void main(String[] args) {
		ExecutorService eService = Executors.newCachedThreadPool();
		final Exchanger<String> exchanger = new Exchanger<String>();
		eService.execute(new Runnable() {
			public void run() {
				String date1 = "drags";
				try {
					Thread.sleep(2000);
					System.out.println(Thread.currentThread().getName() + " the date befor " + date1
							+ " the date after :" + exchanger.exchange(date1));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		eService.execute(new Runnable() {
			public void run() {
				String date2 = "money";
				try {
					Thread.sleep(2000);
					System.out.println(Thread.currentThread().getName() + " the date befor " + date2
							+ " the date after :" + exchanger.exchange(date2));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		eService.shutdown();
	}

}
