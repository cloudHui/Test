package com.sc.test.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//import java.util.Date;

public class CurruntUtilLock {

	// @SuppressWarnings("deprecation")
	public static void main(String[] args) {

		// System.out.println(new Date().getSeconds());
		new CurruntUtilLock();
	}

	private CurruntUtilLock() {
		final Outputer outputer = new Outputer();
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					// try {
					// Thread.sleep(100);
					// } catch (InterruptedException e) {
					// e.printStackTrace();
					// }
					outputer.outputer("cloud iriliya");
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					// try {
					// Thread.sleep(100);
					// } catch (InterruptedException e) {
					// e.printStackTrace();
					// }
					outputer.outputer("liuyunhui chris");
				}
			}
		}).start();
		// new Thread(new Runnable() {
		// public void run() {
		// while (true) {
		// try {
		// Thread.sleep(100);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// Outputer.outputer2("brounce charis");
		// }
		// }
		// }).start();
	}

	static class Outputer {
		// @SuppressWarnings("deprecation")
		Lock lock = new ReentrantLock();

		private void outputer(String name) {
			// synchronized (Outputer.class) {
			try {
				lock.lock();
				for (char i : name.toCharArray()) {
					System.out.print(i);
				}
				System.out.println();
				System.out.println();
			} finally {
				lock.unlock();
			}
			// System.out.println(new Date().getSeconds());
			// }

		}

		// @SuppressWarnings("deprecation")
		private synchronized void outputer1(String name) {
			for (char i : name.toCharArray()) {
				System.out.print(i + "  ");
			}
			System.out.println();
			System.out.println();
			// System.out.println(new Date().getSeconds());
		}

		private static synchronized void outputer2(String name) {
			for (char i : name.toCharArray()) {
				System.out.print(i + "  ");
			}
			System.out.println();
			System.out.println();
			// System.out.println(new Date().getSeconds());
		}
	}
}
