package com.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sample.dto.SampleDTO;

@Component
public class HystrixClient {

	@Autowired
	private IMicroServiceOneClient microServiceOneClient;

	@Autowired
	private IMicroServiceTwoClient microServiceTwoClient;

	@HystrixCommand(fallbackMethod = "retrieveFallbackMicroServiceOne")
	public SampleDTO homeMicroServiceOne() {
		return microServiceOneClient.homeMicroServiceOne();
	}

	public SampleDTO retrieveFallbackMicroServiceOne() {
		SampleDTO sampleDTO = new SampleDTO();
		sampleDTO.setHost("MicroService-ONE is DOWN");
		return sampleDTO;
	}

	@HystrixCommand(fallbackMethod = "retrieveFallbackMicroServiceTwo")
	public SampleDTO homeMicroServiceTwo() {
		return microServiceTwoClient.homeMicroServiceTwo();
	}

	public SampleDTO retrieveFallbackMicroServiceTwo() {
		SampleDTO sampleDTO = new SampleDTO();
		sampleDTO.setHost("MicroService-TWO is DOWN");
		return sampleDTO;
	}
}
