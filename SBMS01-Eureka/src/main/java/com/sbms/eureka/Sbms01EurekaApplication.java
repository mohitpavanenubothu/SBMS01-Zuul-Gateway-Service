package com.sbms.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Sbms01EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sbms01EurekaApplication.class, args);
	}

}
