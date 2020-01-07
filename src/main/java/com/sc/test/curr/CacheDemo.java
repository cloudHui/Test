package com.sc.test.curr;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class CacheDemo {

	private Map<String, Object> cache = new HashMap<String, Object>();
	private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	public static void main(String[] args) {
		CacheDemo cDemo = new CacheDemo();
		for (Object object : cDemo.cache.values()) {
			if (object != null) {
				System.out.println("hashcode" + object.hashCode());
			}
		}
		System.out.println(cDemo.cache.entrySet().size());
	}

	public CacheDemo() {
		cache.put("cloud", "qweq");
		cache.put("cloudq21", "qweq");
		cache.put("12123", "eerwdvwe");
	}

	public Object readObject(String key) {
		Object date = null;
		try {
			readWriteLock.readLock().lock();
			date = cache.get(key);
			if (date == null) {
				readWriteLock.readLock().unlock();
				readWriteLock.writeLock().lock();
				try {
					if (date == null) {
						/**read from Db*/
						date = "read from db";
						cache.put(key, date);
					}
				} finally {
					readWriteLock.writeLock().unlock();
				}
				readWriteLock.readLock().lock();
			}
		} finally {
			readWriteLock.readLock().unlock();
		}
		return date;
	}

	public void writefromDb(Object date) {
		try {
			readWriteLock.writeLock().lock();
			cache.put(date.toString(), date);
		} finally {
			readWriteLock.writeLock().unlock();
			;
		}
	}

}
