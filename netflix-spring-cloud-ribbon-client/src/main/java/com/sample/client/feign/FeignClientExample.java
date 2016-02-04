package com.sample.client.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.dto.SampleDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FeignClientExample {

	@Autowired
	private IMicroServiceOneClient microServiceOneClient;

	@Autowired
	private IMicroServiceTwoClient microServiceTwoClient;

	public SampleDTO homeMicroServiceOne() throws Exception {
		return microServiceOneClient.homeMicroServiceOne();

	}

	public SampleDTO homeMicroServiceTwo() throws Exception {
		return microServiceTwoClient.homeMicroServiceTwo();
	}
}
