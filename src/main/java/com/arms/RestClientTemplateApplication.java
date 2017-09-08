package com.arms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestClientTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestClientTemplateApplication.class, args);
		final String URI = "http://localhost:8080/todos";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> listResponse = restTemplate.getForEntity(URI, String.class);
	}
}
