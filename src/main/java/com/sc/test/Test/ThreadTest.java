package com.sc.test.Test;


public class ThreadTest {

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

}

class Business {
	boolean bshouldgo = true;

	public synchronized void son(int i, String name, int time) {
		try {
			while (!bshouldgo) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 1; j < time; j++) {
				System.out.println(name + " thread sequece :" + j + " loop of " + i);
			}
		} finally {
			bshouldgo = false;
			this.notify();
		}
		

	}

	public synchronized void main(int i, String name, int time) {
		try {
			while (bshouldgo) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 1; j < time; j++) {
				System.out.println(name + " thread sequece :" + j + " loop of " + i);
			}
		} finally {
			bshouldgo = true;
			this.notify();
		}
		
	}
}
