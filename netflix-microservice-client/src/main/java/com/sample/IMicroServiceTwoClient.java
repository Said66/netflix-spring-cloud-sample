package com.sample;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.dto.SampleDTO;

@FeignClient("zuulserver")
public interface IMicroServiceTwoClient {

	 @RequestMapping(method = RequestMethod.GET, value = "/microservicetwo")
	 public SampleDTO homeMicroServiceTwo();
}
