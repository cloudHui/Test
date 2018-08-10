package com.sc.test.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * * @author Cloud Liu
 * 
 * @date create time :2017年12月4日 下午12:15:53
 * @version 1.0
 */

public class CollectionModifyException {

	public static void main(String[] args) {
		Collection<User> user = 
//				new CopyOnWriteArrayList<User>(); 
				new ArrayList<User>();
		user.add(new User("1", new Random().nextInt(200)));
		user.add(new User("2", new Random().nextInt(200)));
		user.add(new User("3", new Random().nextInt(200)));
		Iterator<User> iterator = user.iterator();
		while (iterator.hasNext()) {
			User user2 = iterator.next();
			if (user2.getName().equals("1")) {
//				user.remove(user2);
				iterator.remove();
			} else {
				System.out.println(user2.toString());
			}
		}
	}
}
