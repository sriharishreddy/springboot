package com.harishkumarreddy.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigClientApplication {
	@Value("{application.service.name}")
	private static String serviceName;
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
		
		System.out.println(serviceName);
	}

}
