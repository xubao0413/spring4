package com.bjsxt.test;

public class Demo {
	public void demo1(String name,int age) throws Exception{
//		int i = 5/0;
		System.out.println("两个参数:" + name + "," + age);
	}
	
	public void demo1(String name){
		System.out.println("一个参数:" + name);
	}
}
