package com.tupelo.jvm;

/**
 * @Author: caichuang
 * @Date: 2023/2/20 11:21
 */
public class User {

	public static String a = "haha";


	public static void main(String[] args) {

		String aa = new String("1") + new String("1");
		aa.intern();
		String b = "11";
		System.out.println(aa==b);

//		a = "basd";
//		System.out.println(a);

	}
}
