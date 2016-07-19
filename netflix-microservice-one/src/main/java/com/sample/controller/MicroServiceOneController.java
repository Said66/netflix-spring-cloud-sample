package com.sample.controller;

import com.sample.dto.SampleDTO;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Data
@Controller
public class MicroServiceOneController {
	
	@Value("${server.port}")
	String serverPort;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@RequestMapping("/")
	@ResponseBody
	SampleDTO homeMicroServiceOne() {

        log.debug("Executing homeMicroServiceOne");
		ServiceInstance localInstance = discoveryClient.getLocalServiceInstance();
		SampleDTO sampleDTO = new SampleDTO();
		sampleDTO.setHost(localInstance.getHost());
		sampleDTO.setPort(localInstance.getPort());
		sampleDTO.setServiceId( localInstance.getServiceId());
		return sampleDTO;
		
		//return "Hello World "+ localInstance.getServiceId()+":"+localInstance.getHost()+":"+localInstance.getPort();
	}
}
