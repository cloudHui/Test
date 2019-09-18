package com.sc.test.study;

public class Fibonacci1 {
	//斐波那契数列中的递归	
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
	    System.out.println(fibonacci(40));
	    System.out.println("用时：" + (System.currentTimeMillis() - time) + "ms");
	}
	//递归调用
	public static int fibonacci(int n){	//此算法在N=40时出现明显卡顿
		if(n==0) return 0;
		if(n==1) return 1;
		return fibonacci(n-1)+fibonacci(n-2);
	}
}