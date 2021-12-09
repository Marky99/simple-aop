package com.marky99.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	public String getFortune() {
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "This is a fortune";
	}

	public String getFortune(boolean tripWire) {
		if(tripWire) {
			throw new RuntimeException("Major accident.");
		}
		
		return getFortune();
	}
}
