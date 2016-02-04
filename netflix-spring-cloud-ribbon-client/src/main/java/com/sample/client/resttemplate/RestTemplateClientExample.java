package com.sample.client.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sample.dto.SampleDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RestTemplateClientExample {

	@Autowired
	private RestTemplate restTemplate;


	public SampleDTO homeMicroServiceOne() throws Exception {
		ResponseEntity<SampleDTO> exchange = this.restTemplate.exchange("http://microservice-one", HttpMethod.GET, null, SampleDTO.class);
		SampleDTO sampleDTO = exchange.getBody();
		return sampleDTO;
	}
	
	public SampleDTO homeMicroServiceTwo() throws Exception {
		ResponseEntity<SampleDTO> exchange = this.restTemplate.exchange("http://microservice-two", HttpMethod.GET, null, SampleDTO.class);
		SampleDTO sampleDTO = exchange.getBody();
		return sampleDTO;
	}

}