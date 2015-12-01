package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.HystrixClient;
import com.sample.dto.SampleDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ClientController {

	@Autowired
	private HystrixClient hystrixClient;

	@RequestMapping("/")
	public String printPhrase() {
		
		SampleDTO sampleDTO1 = hystrixClient.homeMicroServiceOne();
		log.debug(sampleDTO1.toString());
		SampleDTO sampleDTO2 = hystrixClient.homeMicroServiceTwo();
		log.debug(sampleDTO2.toString());
		
		StringBuffer stringBuffer = new StringBuffer();
		 stringBuffer.append(" - ").append(sampleDTO1.toString()).append("<br>");
		 stringBuffer.append(" - ").append(sampleDTO2.toString()).append("<br>");

		return stringBuffer.toString();
	}
}
