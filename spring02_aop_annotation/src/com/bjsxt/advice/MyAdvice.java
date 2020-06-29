package com.bjsxt.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

	@Pointcut("execution(* com.bjsxt.test.Demo.demo1(..))")
	public void anyMethod1() {
		//这只是定义一个切入点，方便各种通知的引用，这个方法没有实际的意义
	}
	@Pointcut("execution(* com.bjsxt.test.Demo.demo())")
	public void anyMethod() {
		//这只是定义一个切入点，方便各种通知的引用，这个方法没有实际的意义
	}
	
	
	@Before(value="anyMethod1()&&args(name)")
	public void mybefore1(String name){
		System.out.println("前置,"+name);
	}
	
	@Before("anyMethod()")
	public void mybefore(){
		System.out.println("前置");
	}
	
	@AfterReturning(pointcut="anyMethod()")
	public void myaftering(){
		System.out.println("后置2");
	}
	
	@After("anyMethod()")
	public void myafter(){
		System.out.println("后置1");
	}
	
	@AfterThrowing(pointcut="anyMethod()", throwing="e")
	public void mythrow(Exception e){
		System.out.println("异常,"+e.getMessage());
	}
	
	@Around(value = "anyMethod()")
	public Object myarround(ProceedingJoinPoint p) throws Throwable{
		System.out.println("执行环绕");
		System.out.println("环绕-前置");
		Object result = p.proceed();
		System.out.println("环绕后置");
		return result;
	}
}
