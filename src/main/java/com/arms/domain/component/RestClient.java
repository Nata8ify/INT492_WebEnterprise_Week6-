package com.arms.domain.component;

import java.util.HashMap;
import java.util.Map;

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
	
	public User createUser(String name){
		User user = new User("Moore");
		return restOperations.postForObject(URI, user, User.class);
	}
	
	public String updateUser(int id, String name){
		User user = new User(id, name);
		restOperations.put(URI+"/{id}", user, User.class);
		return "user id : "+id+" is updated.";
	}
	
	public String deleteUser(int id){
		Map<String, Integer> vars = new HashMap<String, Integer>();
		vars.put("id", 2);
		restOperations.delete(URI+"/{id}", vars);
		return "user id : "+vars.get("id")+" is deleted.";
	}
}
