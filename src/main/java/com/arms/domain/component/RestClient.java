package com.arms.domain.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.arms.domain.entity.User;

@Component("rsClnt")
public class RestClient {
	final String URI = "http://localhost:8080/todos";

	@Autowired
	private RestOperations restOperations;
	
	public String getAllUsers(){
		return restOperations.getForObject(URI, String.class);
	}
	
	public User createUser(){
		User user = new User("Moore");
		return restOperations.postForObject(URI, user, User.class);
	}
}
