package com.sample.client.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.dto.SampleDTO;

@FeignClient("microservice-two")
public interface IMicroServiceTwoClient {

	 @RequestMapping(method = RequestMethod.GET, value = "/")
	 public SampleDTO homeMicroServiceTwo();
}
