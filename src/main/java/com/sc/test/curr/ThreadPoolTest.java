package com.sc.test.curr;

import net.sf.cglib.proxy.Enhancer;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//import org.springframework.cglib.proxy.Enhancer;
//import java.lang.reflect.Method;
//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;

public class ThreadPoolTest {
	public static void main(String[] args) {
		// 固定数量的线程
		// ExecutorService threadPool = Executors.newFixedThreadPool(8);
		// 随任务所需的线程个数起线程
		// ExecutorService threadPool = Executors.newCachedThreadPool();
		// 单个线程的线程池，这个线程死掉会重新new 一个继续代替
		// ExecutorService threadPoll = Executors.newSingleThreadExecutor();
		// Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
		//
		// public void run() {
		// System.out.println("++++++booming");
		// }
		// }, 6, 2, TimeUnit.SECONDS);
		Executors.newScheduledThreadPool(3).scheduleWithFixedDelay(new Runnable() {

			public void run() {
				System.out.println(Thread.currentThread().getName() + "++++++booming");
			}
		}, 6, 2, TimeUnit.SECONDS);
		Enhancer enhancer = new Enhancer();
		enhancer.create();
		// for (int i = 0; i < 10; i++) {
		// final int task = i;
		// threadPool.execute(new Runnable() {
		// public void run() {
		// for (int j = 0; j < 10; j++) {
		// try {
		// Thread.sleep(200);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// System.out.println(
		// j + "time" + "thread name : " + Thread.currentThread().getName() + "loop of "
		// + task);
		// }
		// }
		// });
		// }
		// System.out.println("put all task into pool");
		// threadPool.shutdownNow();

	}

}
