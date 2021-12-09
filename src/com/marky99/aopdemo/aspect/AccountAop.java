package com.marky99.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.marky99.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class AccountAop {
	
	Logger myLogger = Logger.getLogger(AccountAop.class.getName());
	
	@Before("com.marky99.aopdemo.aspect.AopExpressions.packagePointCut()")
	public void beforeMessage(JoinPoint joinPoint) {
		
		String methodSig = joinPoint.getSignature().toShortString();
		
		myLogger.info("Before message of method: " + methodSig);
	}
	
	@AfterReturning(
			pointcut="com.marky99.aopdemo.aspect.AopExpressions.packagePointCut()",
			returning="result")
	public void returnAccountsInLog(JoinPoint joinPoint, List<Account> result) {
		Account tempAccount1 = result.get(0);
		tempAccount1.setName("Hello");
		myLogger.info("After Message -------");
		for(Account tempAccount2 : result) {
			myLogger.info(tempAccount2.toString());
		}
		myLogger.info("-----------");
	}
	
	@AfterThrowing(
			pointcut="com.marky99.aopdemo.aspect.AopExpressions.packagePointCut()",
			throwing="exc")
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable exc) {
		
		String adviceMethod = joinPoint.getSignature().toShortString();
		myLogger.info("Method: " + adviceMethod);
		
		myLogger.info("Exception from method: " + exc);
	}
	
	@After("com.marky99.aopdemo.aspect.AopExpressions.packagePointCut()")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		
		String methodName = joinPoint.getSignature().toShortString();
		
		myLogger.info("This is @After (Finally) of method: " + methodName);
	}
	
	@Around("execution(* com.marky99.aopdemo.service.*.*(..))")
	public Object arroundFortune(
			ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		String method = proceedingJoinPoint.getSignature().toShortString();
		
		myLogger.info("@Around of Method is: " + method);
		
		long start = System.currentTimeMillis();
		
		Object result = null;
		
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			myLogger.warning(e.getMessage());
			
			//result="Major accident. hay";
			
			throw e;
		}
		
		long end = System.currentTimeMillis();
		
		long duration = end - start;
		
		myLogger.info("\n=======> Duration: " + duration / 1000.0 + " seconds");
		
		return result;
	}
}
