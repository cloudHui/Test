package com.sc.test.curr;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadLocalTest {

	// public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

	public static ThreadLocal<ThreadDate> threadLocal = new ThreadLocal<ThreadDate>();

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int data = (int) (new Random().nextInt(1000));
					/**threadLocal.set(data);*/
					ThreadDate threadDate = ThreadDate.getThreadInstance();
					threadDate.setName("name:" + data);
					threadDate.setAge(data);
					threadLocal.set(threadDate);
					Map<String, Integer> map1 = new HashMap<String, Integer>(10);
					for (Integer  string : map1.values()){
						System.out.println("string " + string);
					}
					System.out.println("currentThread" + Thread.currentThread().getName() + "data :" + data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}

	static class A {
		public synchronized void get() {
			System.out.println("A currentThread " + Thread.currentThread().getName());
			// int data = threadLocal.get();
			// System.out.println(Thread.currentThread().getName() + "A data :" + data);
			System.out.println(Thread.currentThread().getName() + "A data name :" + threadLocal.get().getName() + " age " + threadLocal.get().getAge());
		}
	}

	static class B {
		public synchronized void get() {
			System.out.println("B currentThread " + Thread.currentThread().getName());
			// int data = threadLocal.get();
			// System.out.println(Thread.currentThread().getName() + "B data :" + data);
			System.out.println(Thread.currentThread().getName() + "B data name :" + threadLocal.get().getName() + " age " + threadLocal.get().getAge());
		}
	}

}

class ThreadDate {
	/**private static ThreadDate ThreadIntance = null;*/
	private static ThreadLocal<ThreadDate> map = new ThreadLocal<ThreadDate>();
	private String name;
	private int age;

	private ThreadDate() {
	}

	public static ThreadDate getThreadInstance() {
		ThreadDate threadIntance = map.get();
		if (threadIntance == null) {
			threadIntance = new ThreadDate();
			map.set(threadIntance);
		}
		return threadIntance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
