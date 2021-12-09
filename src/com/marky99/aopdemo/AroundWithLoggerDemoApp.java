package com.marky99.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.marky99.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	public static void main(String[] args) {

		Logger myLogger = 
				Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneService = context.getBean(TrafficFortuneService.class);
		
		myLogger.info("Calling getFortune");
		
		String data = trafficFortuneService.getFortune();
		
		myLogger.info("\nFortune is: " + data);
		
		myLogger.info("\nFinished");
		
		context.close();
	}

}
