package com.marky99.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.marky99.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	public static void main(String[] args) {

		Logger myLogger = 
				Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneService = context.getBean(TrafficFortuneService.class);
		
		myLogger.info("Calling getFortune");
		
		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);
		
		myLogger.info("\nFortune is: " + data);
		
		myLogger.info("\nFinished");
		
		context.close();
	}

}
