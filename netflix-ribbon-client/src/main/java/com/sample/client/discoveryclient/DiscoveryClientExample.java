package com.sample.client.discoveryclient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DiscoveryClientExample {

	@Autowired
	private DiscoveryClient discoveryClient;

	public void homeMicroServiceOne() throws Exception {
		discoveryClient.getInstances("microservice-one").forEach((ServiceInstance s) -> {
			log.debug(ToStringBuilder.reflectionToString(s));
		});

	}

	public void homeMicroServiceTwo() throws Exception {
		discoveryClient.getInstances("microservice-two").forEach((ServiceInstance s) -> {
			log.debug(ToStringBuilder.reflectionToString(s));
		});
	}
}