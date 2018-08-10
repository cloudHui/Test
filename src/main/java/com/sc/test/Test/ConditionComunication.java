package com.sc.test.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionComunication {

	public static void main(String[] args) {
		final Business business = new Business();
		new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i < 51; i++) {
					business.son(i, "son", 11);
				}
			}
		}).start();
		for (int i = 1; i < 51; i++) {
			business.main(i, "main", 101);
		}
	}

	static class Business {
		boolean bshouldgo = true;

		Lock lock = new ReentrantLock();
		Condition lCondition = lock.newCondition();

		public void son(int i, String name, int time) {
			try {
				lock.lock();
				while (!bshouldgo) {
					try {
						// this.wait();
						lCondition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int j = 1; j < time; j++) {
					System.out.println(name + " thread sequece :" + j + " loop of " + i);
				}

				lCondition.signal();
				bshouldgo = false;
				// this.notify();
			} finally {
				lock.unlock();
			}
		}

		public void main(int i, String name, int time) {
			try {
				lock.lock();
				while (bshouldgo) {
					try {
						// this.wait();
						lCondition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int j = 1; j < time; j++) {
					System.out.println(name + " thread sequece :" + j + " loop of " + i);
				}
				lCondition.signal();
				bshouldgo = true;
				// this.notify();
			} finally {
				lock.unlock();
			}

		}
	}

}
