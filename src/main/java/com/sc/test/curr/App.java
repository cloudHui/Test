package com.sc.test.curr;

/**
 * Hello world!
 * @author cloud
 */
public class App {
	public static void main(String[] args) {
		if (null != args) {
			// if(args.length!=0)
			System.out.println(args.length);
			// }
			System.out.println(args.toString());
		}

		System.out.println("Hello World!");
		Thread thread = new Thread() {
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(500);
						System.out.println(Thread.currentThread().getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();
		Thread thread2 = new Thread(new  Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(500);
						System.out.println(Thread.currentThread().getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread2.start();
		
		
		new Thread(new Runnable() {
			@Override
 			public void run() {
				while(true) {
					try {
						Thread.sleep(500);
						System.out.println(Thread.currentThread().getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}) {
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(500);
						System.out.println(Thread.currentThread().getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			};
		}.start();

	}
}
