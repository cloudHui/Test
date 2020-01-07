package com.sc.test.curr;

//import java.util.Date;

public class ThreadSynchronized {

//	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

//		System.out.println(new Date().getSeconds());
		new ThreadSynchronized();
	}

	private  ThreadSynchronized() {
		final Outputer outputer = new Outputer();
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputer.outputer("cloud   chris");
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputer.outputer1("liuyunhui  iriliya");
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Outputer.outputer2("brounce  charis");
				}
			}
		}).start();
	}

	 static class Outputer {
//		@SuppressWarnings("deprecation")
		private void outputer(String name) {
			synchronized (Outputer.class) {
				for (char i : name.toCharArray()) {
					System.out.print(i + "  ");

				}
				System.out.println();
				System.out.println();
//				System.out.println(new Date().getSeconds());
			}
		}

//		@SuppressWarnings("deprecation")
		private synchronized void outputer1(String name) {
			for (char i : name.toCharArray()) {
				System.out.print(i + "  ");

			}
			System.out.println();
			System.out.println();
//			System.out.println(new Date().getSeconds());
		}
		private static synchronized void outputer2(String name) {
			for (char i : name.toCharArray()) {
				System.out.print(i + "  ");

			}
			System.out.println();
			System.out.println();
//			System.out.println(new Date().getSeconds());
		}
	}
}
