package com.bjsxt.test;

import org.springframework.stereotype.Component;

@Component
public class Demo {
	public void demo() throws Exception{
//		int i = 5/0;
		System.out.println("demo方法");
	}
	
	public void demo1(String name) throws Exception{
//		int i = 5/0;
		System.out.println("demo1方法,"+name);
	}
}
