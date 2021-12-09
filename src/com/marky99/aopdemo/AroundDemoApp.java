package com.marky99.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.marky99.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneService = context.getBean(TrafficFortuneService.class);
		
		System.out.println("Calling getFortune");
		
		String data = trafficFortuneService.getFortune();
		
		System.out.println("\nFortune is: " + data);
		
		System.out.println("\nFinished");
		
		context.close();
	}

}
