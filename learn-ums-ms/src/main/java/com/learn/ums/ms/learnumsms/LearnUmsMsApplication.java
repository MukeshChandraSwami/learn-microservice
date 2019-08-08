package com.learn.ums.ms.learnumsms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LearnUmsMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnUmsMsApplication.class, args);
	}

}
