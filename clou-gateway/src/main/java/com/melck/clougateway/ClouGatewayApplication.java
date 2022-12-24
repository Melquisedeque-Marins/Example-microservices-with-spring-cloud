package com.melck.clougateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClouGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClouGatewayApplication.class, args);
	}

}
