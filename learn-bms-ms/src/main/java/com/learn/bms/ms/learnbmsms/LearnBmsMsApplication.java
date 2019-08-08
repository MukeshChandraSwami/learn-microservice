package com.learn.bms.ms.learnbmsms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LearnBmsMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnBmsMsApplication.class, args);
	}

}
