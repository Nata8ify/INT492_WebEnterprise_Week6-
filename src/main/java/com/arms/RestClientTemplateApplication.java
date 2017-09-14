package com.arms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.arms.domain.component.RestClient;

@SpringBootApplication
public class RestClientTemplateApplication {
	//public static final Logger logger = LoggerFactory.getLogger(RestClientTemplateApplication.class);
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(RestClientTemplateApplication.class, args);
		System.out.println(((RestClient)context.getBean("rsClnt")).getAllUsers());	
		System.out.println(((RestClient)context.getBean("rsClnt")).createUser("Carl"));	
		System.out.println(((RestClient)context.getBean("rsClnt")).updateUser(4, "David"));	
		System.out.println(((RestClient)context.getBean("rsClnt")).deleteUser(5));
	}
}
