package com.sbms.payment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbms.payment.client.IOrderServiceRestConsumer;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	Logger logger = LoggerFactory.getLogger(PaymentController.class);

	@Autowired
	private IOrderServiceRestConsumer feignConsumer;

	@Value("${server.port}")
	private int port;

	@GetMapping("/test")
	public ResponseEntity<String> paymentTest() {
		logger.info("Welcome to Payment Service with port number " + port);
		String body = feignConsumer.fetchOrderServiceData();
		return new ResponseEntity<String>(body, HttpStatus.OK);

	}

}
