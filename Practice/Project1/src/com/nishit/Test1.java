package com.nishit;

import java.lang.reflect.Method;

public class Test1 {

	public static void main(String[] args) throws ClassNotFoundException {
		int count = 0;
		Class c = Class.forName("java.lang.Object");
		Method[] m = c.getDeclaredMethods();
		
		for(Method m1 : m) { 
			System.out.println(m1.getName());
			count++;
		}
		System.out.println("The number of methods " +count);
	}
}
