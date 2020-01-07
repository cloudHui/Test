package com.sc.test.curr;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class ThreadScopeShareDate {

	public static Map<Thread, Integer> dataMap = new HashMap<Thread, Integer>();

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				public void run() {
					int data = (int) (new Random().nextInt(1000));
					dataMap.put(Thread.currentThread(), data);
					System.out.println("currentThread" + Thread.currentThread().getName() + "data :" + data);
					Set<Thread> keys = dataMap.keySet();
					Set<Entry<Thread, Integer>> entrise = dataMap.entrySet();
					for (Entry<Thread, Integer> entry : entrise) {
						System.out.println(entry.getKey() + " " + entry.getValue());
					}
					for (Thread thread : keys) {
						System.out.println("Threadname :" + thread.getName());
					}
					System.out.println();
					new A().get();
					new B().get();
				}
			}).start();
		}
	}

	static class A {
		public synchronized void get() {
			System.out
					.println("A currentThread " + Thread.currentThread().getName() + " datamap.size:" + dataMap.size());
			int data = dataMap.get(Thread.currentThread());
			System.out.println(Thread.currentThread().getName() + "A  data :" + data);
		}
	}

	static class B {
		public synchronized void get() {
			System.out
					.println("B currentThread " + Thread.currentThread().getName() + " datamap.size:" + dataMap.size());
			int data = dataMap.get(Thread.currentThread());
			System.out.println(Thread.currentThread().getName() + "B  data :" + data);
		}
	}

}
