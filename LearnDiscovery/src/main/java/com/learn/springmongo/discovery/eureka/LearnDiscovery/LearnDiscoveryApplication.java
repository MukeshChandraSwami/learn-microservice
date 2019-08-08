package com.learn.springmongo.discovery.eureka.LearnDiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LearnDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnDiscoveryApplication.class, args);
	}

}
