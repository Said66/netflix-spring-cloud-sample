package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.client.discoveryclient.DiscoveryClientExample;
import com.sample.client.feign.FeignClientExample;
import com.sample.client.resttemplate.RestTemplateClientExample;
import com.sample.dto.SampleDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ClientController {

	// @Autowired
	// private HystrixClient hystrixClient;

	@Autowired
	RestTemplateClientExample restTemplateClientExample;
	@Autowired
	DiscoveryClientExample discoveryClientExample;
	@Autowired
	FeignClientExample feignClientExample;

	@RequestMapping("/")
	public String printPhrase() throws Exception {

		SampleDTO sampleDTO1 = restTemplateClientExample.homeMicroServiceOne();
		log.debug(sampleDTO1.toString());
		SampleDTO sampleDTO2 = restTemplateClientExample.homeMicroServiceTwo();
		log.debug(sampleDTO2.toString());

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("RESTTEMPLATECLIENTEXAMPLE  - ").append(sampleDTO1.toString()).append("<br>");
		stringBuffer.append("RESTTEMPLATECLIENTEXAMPLE - ").append(sampleDTO2.toString()).append("<br>");
		stringBuffer.append("=============================").append("<br>");
		
		
		sampleDTO1 = feignClientExample.homeMicroServiceOne();
		log.debug(sampleDTO1.toString());
		sampleDTO2 = feignClientExample.homeMicroServiceTwo();
		log.debug(sampleDTO2.toString());
		stringBuffer.append("FEIGNCLIENTEXAMPLE  - ").append(sampleDTO1.toString()).append("<br>");
		stringBuffer.append("FEIGNCLIENTEXAMPLE - ").append(sampleDTO2.toString()).append("<br>");
		stringBuffer.append("=============================").append("<br>");
		
		discoveryClientExample.homeMicroServiceOne();
		discoveryClientExample.homeMicroServiceTwo();
		


		return stringBuffer.toString();
	}
}
