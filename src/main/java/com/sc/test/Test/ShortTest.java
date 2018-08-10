package com.sc.test.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ShortTest {

	private Object[] object = new Object[100];
	private int index = 0;

	public static void main(String[] args) {
		// for (int i = 0; i < 10; i++) {
		// int randomNumber = new Random().nextInt(2) * 1000;
		// System.out.println(" random number : " + randomNumber);
		// try {
		// Thread.sleep(randomNumber);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		URL url = null;
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			url = new URL("https://www.baidu.com");
			is = url.openStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String data = br.readLine();
			while (data != null) {
				char c[] = data.toCharArray();
				for (int i = 0; i < c.length; i++) {
					System.out.print(c[i]);
					if (c[i] == '>') {
						System.out.println();
					}
				}
				data = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				isr.close();
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		ShortTest sTest = new ShortTest();
		System.out.println(sTest.object.length + " " + (sTest.index++));
		System.out.println(sTest.index);

		String s1 = "a";
		String s2 = s1 + "b";
		String s3 = "a" + "b";
		System.out.println(s2 == "ab");
		System.out.println(s3 == "ab");
		System.out.println(s2 + s3);
		System.out.println(s2 == s3);
		System.out.println("返回" + sTest.tryFinally());
	}

	@SuppressWarnings("finally")
	public int tryFinally() {
		int i = 1;
		try {
			i++;
			System.out.println("try" + i);
			// int c = 1 / 0;
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("catch");
			return 1;
		} finally {
			++i;
			System.out.println("finally" + i);
			// return i;
		}
	}
}
