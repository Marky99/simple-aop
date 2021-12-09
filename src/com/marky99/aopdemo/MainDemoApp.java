package com.marky99.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.marky99.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean(AccountDAO.class);
		
		List<Account> accounts = null;
			
			
		
		try {
			boolean tripWire = true;
			accounts = accountDAO.findAccount(tripWire);
		}
		catch(Exception e) {
			System.out.println("\n\nMain Program ... caught exception: " + e);
		}
	}

}
