package com.sbms.order.controller;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/order")
public class OrderController {

	int count = 0;

	Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Value("${server.port}")
	private int port;

	@GetMapping("/test")
	public ResponseEntity<String> orderTest() {
		logger.info("Welcome to Order Service with port number is " + port);
		String body = "Welcome to Order Service with port number is " + port;
		return new ResponseEntity<String>(body, HttpStatus.OK);
	}

	@GetMapping("/book")
	@HystrixCommand(fallbackMethod = "bookFallbackTicket", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
			@HystrixProperty(name = "circuitBreaker.enabled", value = "true") })
	public String bookTicket() {
		logger.info("Inside the OrderController for circuit breaker");
		if (new Random().nextInt(10) < 8)
			throw new RuntimeException("Problem occured in actual method");
		return "Fault tolerance Hystrix circuit breaker success";
	}

	public String bookFallbackTicket() {
		count++;
		System.out.println("OrderController.bookFallbackTicket()" + count);
		logger.info("Inside bookFallback method");
		return "Please try later-Server is under maintainance";
	}

}
