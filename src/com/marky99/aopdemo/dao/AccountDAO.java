package com.marky99.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.marky99.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void showMessage() {
		System.out.println("Hello");
	}
	
	public List<Account> findAccount(boolean tripWire) {
		
		if(tripWire) {
			throw new RuntimeException("Error please reffer to admin");
		}
		
		List<Account> myAccounts = new ArrayList<Account>();
		
		Account account1 = new Account("Marek", "M@example.com");
		Account account2 = new Account("Timka", "T@example.com");	
		Account account3 = new Account("Limka", "L@example.com");
		
		myAccounts.add(account1);
		myAccounts.add(account2);
		myAccounts.add(account3);
		
		return myAccounts;
	}
}
