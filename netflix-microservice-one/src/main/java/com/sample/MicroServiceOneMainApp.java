package com.sample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
@EnableAutoConfiguration
@EnableDiscoveryClient
public class MicroServiceOneMainApp {
	
	@Value("${server.port}")
	String serverPort;
	
	@RequestMapping("/")
	String home() {
		return "MicroServiceOne on port " + serverPort;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MicroServiceOneMainApp.class, args);
	}
}
