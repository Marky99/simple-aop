package com.marky99.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	
	@Pointcut("execution(* com.marky99.aopdemo.dao.*.*(..))")
	public void packagePointCut() {}
	
}
