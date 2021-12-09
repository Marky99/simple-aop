package com.marky99.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.marky99.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean(AccountDAO.class);	
		
		try {
			boolean tripWire = false;
			accountDAO.findAccount(tripWire);
		}
		catch(Exception e) {
			System.out.println("\n\nMain Program ... caught exception: " + e);
		}
		
		context.close();
	}

}
