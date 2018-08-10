package com.sc.test.Test;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallbackAndFutrue {

	public static void main(String[] args) {
		ExecutorService eService = Executors.newSingleThreadExecutor();
		Future<String> future = eService.submit(new Callable<String>() {
			public String call() throws Exception {
				Thread.sleep(3000);
				return "hello";
			}
		});
		System.out.println("等待结果：");
		try {
			System.out.println("拿到的结果：" + future.get());
		} catch (InterruptedException e) {
			System.out.println("被打断了");
			e.printStackTrace();
		} catch (ExecutionException e) {
			System.out.println("执行错误");
			e.printStackTrace();
		}
		System.out.println("第一个执行结束");
		eService.shutdown();
		
		
		
		ExecutorService eService2 = Executors.newFixedThreadPool(10); 
		CompletionService<Integer> cService = new ExecutorCompletionService<Integer>(eService2);
		for(int i = 0 ; i < 10 ;i++) {
			final int call = i; 
			cService.submit(new Callable<Integer>() {
				public Integer call() throws Exception {
					Thread.sleep(new Random().nextInt(3) * 1000 );
					return call;
				}
			});
		}
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(cService.take().get());
			}
		} catch (InterruptedException e) {
			System.out.println("第二个终止错误");
			e.printStackTrace();
		} catch (ExecutionException e) {
			System.out.println("第二个执行错误");
			e.printStackTrace();
		}
		
		System.out.println("第er个执行结束");
		eService2.shutdown();
	}

}
