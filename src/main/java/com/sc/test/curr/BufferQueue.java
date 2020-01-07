package com.sc.test.curr;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author Administrator
 * 缓存队列
 */
public class BufferQueue {

	private Lock lock = new ReentrantLock();
	private Condition unFull = lock.newCondition();
	private Condition unEmpty = lock.newCondition();

	private Object[] object = new Object[100];
	private int index = 0;
	private int count, putIndex, getIndex;

	public static void main(String[] args) {
		final BufferQueue bQueue = new BufferQueue();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					Object object = new Object();
					bQueue.put(object);
					// bQueue.putThey(object);
					System.out.println("put hashcode" + object.hashCode());
				}

			}
		}).start();

		new Thread(new Runnable() {

			public void run() {

				while (true) {
					Object object = bQueue.get();
					// Object object = bQueue.getThey();
					System.out.println("get hashcode :" + object.hashCode());
				}
			}
		}).start();
	}

	/**
	 * 我的后进先出缓存队列模仿jdk自带的先进先出链表，存的时候不超过上限，取的时候永远从最后放的取*/
	private void put(Object x) {
		lock.lock();
		try {
			while ((index + 1) == object.length) {
				try {
					unFull.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			object[index] = x;
			if ((index + 1) == object.length) {
				index = 0;
			} else {
				index++;
			}
			System.out.println("the index after put:" + index);
			unEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	private Object get() {
		lock.lock();
		try {
			while (index == 0) {
				try {
					unEmpty.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Object x = object[index - 1];
			object[index - 1] = null;
			index--;
			System.out.println("the index after get:" + index);
			unFull.signal();
			return x;
		} finally {
			lock.unlock();
		}
	}

	/**
	 * jdk中的boundebuffer先进先出队列,取和读互不干扰
	 */
	private void putThey(Object x) {
		lock.lock();
		try {
			while (count == object.length) {
				try {
					unFull.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			object[putIndex] = x;
			count++;
			System.out.println("the index after put：" + putIndex);
			if (++putIndex == object.length) {
				putIndex = 0;
				System.out.println("reset the index when out");
			}
			unEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	private Object getThey() {
		Object x;
		lock.lock();
		try {
			while (count == 0) {
				try {
					unEmpty.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			x = object[getIndex];
			object[getIndex] = null;
			count--;
			if (++getIndex == object.length) {
				getIndex = 0;
				System.out.println("reset the index when take");
			}
			System.out.println("the index after take：" + getIndex);
			unFull.signal();
		} finally {
			lock.unlock();
		}
		return x;
	}
}
