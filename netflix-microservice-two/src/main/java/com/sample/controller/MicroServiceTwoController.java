package com.sample.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MicroServiceTwoController {
	
	@Value("${server.port}")
	String serverPort;
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
		String str = "Hello World! from " + MicroServiceTwoController.class.getName() + "on port " + serverPort;
		log.debug(str);
		return str;
	}
}