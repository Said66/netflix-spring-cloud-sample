package com.sample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
@EnableZuulProxy
public class ZuulMainApp {
	public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(ZuulMainApp.class).web(true).run(args);
	}
}
