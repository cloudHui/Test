package com.sc.test.curr;

/**
 * * @author Cloud Liu
 * 
 * @date create time :2017年12月4日 下午12:00:16
 * @version 1.0
 */

public class User {

	private String name;
	private int age;
	public User(String name,int age) {
		this.age = age;
		this.name = name;
	}
	public boolean equals(Object object) {
		if(this == object) {
			return true;
		}
		if(!(object instanceof User)) {
			return false ;
		}
		User user = (User) object;
		if(this.name.equals(user.name) && this.age == user.age) {
			return true;
		} else {
			return false;
		}
	}
	
	public int hashCode() {
		return name.hashCode() + age;
	}
	public String toString() {
		return "{name:" + name + ",age:" + age + "}" ;
	} 
	public Object clone() {
		Object object = null;
		try {
			object = super.clone();
		} catch (Exception e) {
			System.out.println("clone fail");
		}
		return object;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
