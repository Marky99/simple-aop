package com.marky99.aopdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.marky99.aopdemo.aspect.AccountAop;
import com.marky99.aopdemo.dao.AccountDAO;
import com.marky99.aopdemo.service.TrafficFortuneService;

@EnableAspectJAutoProxy
@Configuration
public class DemoConfig {
	@Bean
	public AccountDAO accountDAO() {
		return new AccountDAO();
	}
	
	@Bean
	public AccountAop accountAop() {
		return new AccountAop();
	}
	
	@Bean
	public TrafficFortuneService trafficFortuneService() {
		return new TrafficFortuneService();
	}
}
