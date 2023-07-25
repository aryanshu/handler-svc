package com.profile.handlersvc;

import com.profile.handlersvc.datagenerator.DataGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HandlerSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(HandlerSvcApplication.class, args);

	}

}
