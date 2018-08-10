package com.sc.test.Test;

public class MultiThreadShareDate {

	public static void main(String[] args) {
		final Share share = new Share();
		// new Thread(share).start();
		// new Thread(share).start();
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				public void run() {
					while(true) {
						share.dec();
					}
				}
			}).start();
			new Thread(new Runnable() {
				public void run() {
					while(true) {
						share.inc();
					}
				}
			}).start();
		}

	}
}

class Share implements Runnable {
	private int count = 100;

	public void run() {
		while (true) {
			if (count < 1) {
				System.exit(0);
			}
			count--;
			System.out.println("count:" + count);
		}
	}

	public synchronized void dec() {
		if (count < -200) {
			System.exit(0);
		}
		count --;
		System.out.println("减一：count : " + count + Thread.currentThread().getName());
	}

	public synchronized void inc() {
		if (count > 300) {
			System.exit(0);
		}
		count ++;
		System.out.println("加一：count : " + count + Thread.currentThread().getName());
	}
}
