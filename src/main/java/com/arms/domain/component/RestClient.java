package com.arms.domain.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("rsClnt")
public class RestClient {
	final String URI = "http://localhost:8080/todos";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String getAllUsers(){
		return restTemplate.getForObject(URI, String.class);
	}
}
