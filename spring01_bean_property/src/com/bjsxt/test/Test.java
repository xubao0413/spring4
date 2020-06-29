package com.bjsxt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.pojo.People;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		People people = ac.getBean("peo",People.class);
		
		
		System.out.println("当list只有一个参数时，可以通过value直接赋值，如果值有逗号，它是不会进行分割的，长度为:"+people.getList().size());
		
		System.out.println(people);
	}
}
