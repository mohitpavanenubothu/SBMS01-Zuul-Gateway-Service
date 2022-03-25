package com.sbms.zuul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableHystrix
@EnableHystrixDashboard
public class Sbms01ZuulGatewayServiceApplication {
	
	private static Logger logger = LoggerFactory.getLogger(Sbms01ZuulGatewayServiceApplication.class);

	public static void main(String[] args) {
		logger.info("Welcome to Zuul Gateway main class");
		SpringApplication.run(Sbms01ZuulGatewayServiceApplication.class, args);
	}

}
