package com.sc.test.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeConditionComunication {

	/**
	 * 1 2 3 个线程顺序执行
	 */
	public static void main(String[] args) {
		final Business business = new Business();
		new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i < 51; i++) {
					business.first(i, "first", 11);
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i < 51; i++) {
					business.second(i, "second", 21);
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i < 51; i++) {
					business.third(i, "third", 31);
				}
			}
		}).start();
	}

	static class Business {
		int shouldGo = 1;

		Lock lock = new ReentrantLock();
		Condition firstCondition = lock.newCondition();
		Condition secondCondition = lock.newCondition();
		Condition thirdCondition = lock.newCondition();

		public void first(int i, String name, int time) {
			lock.lock();
			try {
				while (shouldGo != 1) {
					try {
						firstCondition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int j = 1; j < time; j++) {
					System.out.println(name + " thread sequece :" + j + " loop of " + i);
				}
				secondCondition.signal();
				shouldGo = 2;
			} finally {
				lock.unlock();
			}
		}

		public void second(int i, String name, int time) {
			lock.lock();
			try {
				while (shouldGo != 2) {
					try {
						secondCondition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int j = 1; j < time; j++) {
					System.out.println(name + " thread sequece :" + j + " loop of " + i);
				}
				shouldGo = 3;
				thirdCondition.signal();
			} finally {
				lock.unlock();
			}

		}

		public void third(int i, String name, int time) {
			lock.lock();
			try {
				while (shouldGo != 3) {
					try {
						thirdCondition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int j = 1; j < time; j++) {
					System.out.println(name + " thread sequece :" + j + " loop of " + i);
				}
				shouldGo = 1;
				firstCondition.signal();
			} finally {
				lock.unlock();
			}

		}
	}

}
