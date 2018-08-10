package com.sc.test.Test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

	public static int count = 0;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		class MyTimerTask3 extends TimerTask {
			@Override
			public void run() {
				count = (count + 1) % 2;
				System.out.println("+++++++++boming");
				new Timer().schedule(new MyTimerTask3(), 2000 + count * 2000);
			}
		}
		new Timer().schedule(new MyTimerTask(),4000);
//		new Timer().schedule(new MyTimerTask3(), 2000);
		while (true) {
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyTimerTask2 extends TimerTask {
	@Override
	public void run() {
		System.out.println("+++++++++boming");
		new Timer().schedule(new MyTimerTask(), 4000);
	}
}

class MyTimerTask extends TimerTask {
	@Override
	public void run() {
		System.out.println("+++++++++boming");
		new Timer().schedule(new MyTimerTask2(), 2000);
	}
}
