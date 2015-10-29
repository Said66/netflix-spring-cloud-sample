package com.sample;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("zuulserver")
public interface IMicroServiceOneClient {

	@RequestMapping(method = RequestMethod.GET, value = "/microserviceone")
	public String homeMicroServiceOne();

}
