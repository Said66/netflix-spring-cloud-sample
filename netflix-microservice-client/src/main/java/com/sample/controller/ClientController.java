package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.HystrixClient;

@RestController
public class ClientController {

	@Autowired
	private HystrixClient hystrixClient;

	@RequestMapping("/")
	public String printPhrase() {

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(" - ").append(hystrixClient.homeMicroServiceOne()).append("<br>");
		stringBuffer.append(" - ").append(hystrixClient.homeMicroServiceTwo()).append("<br>");

		return stringBuffer.toString();
	}
}
