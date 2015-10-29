package com.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class HystrixClient {
	
	@Autowired
	private IMicroServiceOneClient microServiceOneClient;
	
	@Autowired
	private IMicroServiceTwoClient microServiceTwoClient;

	@HystrixCommand(fallbackMethod = "retrieveFallbackMicroServiceOne")
	public String homeMicroServiceOne() {
		return microServiceOneClient.homeMicroServiceOne();
	}

	@HystrixCommand(fallbackMethod = "retrieveFallbackMicroServiceTwo")
	public String homeMicroServiceTwo() {
		return microServiceTwoClient.homeMicroServiceTwo();
	}

	public String retrieveFallbackMicroServiceOne() {
		return "MicroService-ONE is DOWN";
	}

	public String retrieveFallbackMicroServiceTwo() {
		return "MicroService-TWO is DOWN";
	}
}
