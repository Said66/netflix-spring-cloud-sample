package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.IFeignClient;

@RestController
public class FeignController {

	@Autowired
    private IFeignClient iFeignClient;
 
    @RequestMapping("/")
    public String printPhrase() {
    	
    	StringBuffer stringBuffer = new  StringBuffer();
    	stringBuffer.append(" - ").append(iFeignClient.homeOne()).append("<br>");
    	stringBuffer.append(" - ").append(iFeignClient.homeTwo()).append("<br>");
    	
        return stringBuffer.toString();
    }
}
