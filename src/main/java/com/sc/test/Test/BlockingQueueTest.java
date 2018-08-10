package com.sc.test.Test;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * * @author Cloud Liu
 * 
 * @date create time :2017年12月3日 下午4:50:32
 * @version 1.0
 */

/**
 * BlockingQueue 先进先出
 * @author Administrator
 *
 */


public class BlockingQueueTest {

	ExecutorService eService = Executors.newCachedThreadPool();
	final BlockingQueue<Integer> queueOne = new ArrayBlockingQueue<Integer>(1);
	final BlockingQueue<Integer> queueTwo = new ArrayBlockingQueue<Integer>(1);
	final BlockingQueue<Integer> bQueue = new ArrayBlockingQueue<Integer>(3);
	public static void main(String[] args) {
//		new BlockingQueueTest().zuSeDuiLie();
		new BlockingQueueTest().zuSeHuChi();
	}

	public BlockingQueueTest() {
		try {
			queueTwo.put(new Random().nextInt(10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void zuSeDuiLie() {
		eService.execute(new Runnable() {
			public void run() {
				while (true) {
					try {
						Integer number = new Random().nextInt(10);
						bQueue.put(number);
						System.out.println("put number : " + number);
						System.out.println("the number in queue :");
						Iterator<Integer> iterator = bQueue.iterator();
						while (iterator.hasNext()) {
							System.out.print(" " + iterator.next());
						}
						System.out.println();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		eService.execute(new Runnable() {
			public void run() {
				while (true) {
					try {
						Integer number = bQueue.take();
						System.out.println("take number : " + number);
						System.out.println("the number in queue :");
						Iterator<Integer> iterator = bQueue.iterator();
						while (iterator.hasNext()) {
							System.out.print("  " + iterator.next());
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	public void zuSeHuChi() {
		eService.execute(new Runnable() {
			public void run() {
				while(true) {
					try {
						System.out.println(" queueOne is preparing for takeing.... ");
						Integer integer =  queueOne.take();
						System.out.println(" queueOne has token over : " + integer);
						System.out.println(" queueTwo is preparing for putting");
						queueTwo.put(new Random().nextInt(5));
						System.out.println(" queueTwo has put over");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		eService.execute(new Runnable() {
			public void run() {
				while(true) {
					try {
						System.out.println(" queueTwo is preparing for takeing.... ");
						Integer integer =  queueTwo.take();
						System.out.println(" queueTwo has token over : " + integer);
						System.out.println(" queueOne is preparing for putting");
						queueOne.put(new Random().nextInt(5));
						System.out.println(" queueOne has put over");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
	}
}
