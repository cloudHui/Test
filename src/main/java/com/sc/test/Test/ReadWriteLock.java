package com.sc.test.Test;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {

	public static void main(String[] args) {
		final DateProcess dProcess = new DateProcess();
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				public void run() {
					while(true) {
						dProcess.write(new Random().nextInt(10));
					}
				}
			}).start();
			new Thread(new Runnable() {
				public void run() {
					while(true) {
						dProcess.read();
					}
				}
			}).start();
		}

	}

}
class DateProcess{
	private int date = 0;
	private ReentrantReadWriteLock rrwl = new ReentrantReadWriteLock();
	public void read() {
		try {
			rrwl.readLock().lock();
			System.out.println("ready to read date");
			Thread.sleep(new Random().nextInt(3)*1000);
			System.out.println(Thread.currentThread().getName() + " the read date is : " + date );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			rrwl.readLock().unlock();
		}
	}
	public void write(int date) {
		try {
			rrwl.writeLock().lock();
			System.out.println("ready to write date");
			Thread.sleep(new Random().nextInt(3)*1000);
			System.out.println(Thread.currentThread().getName() + " the write date is : " + date );
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			rrwl.writeLock().unlock();
		}
		this.date = date;
	}
}
