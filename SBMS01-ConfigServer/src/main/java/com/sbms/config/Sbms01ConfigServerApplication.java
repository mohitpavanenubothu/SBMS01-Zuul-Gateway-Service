package com.sbms.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class Sbms01ConfigServerApplication {

	public static void main(String[] args) {
		System.out.println("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");
		SpringApplication.run(Sbms01ConfigServerApplication.class, args);
	}

}
