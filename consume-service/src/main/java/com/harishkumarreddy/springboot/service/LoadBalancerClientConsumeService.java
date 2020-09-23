package com.harishkumarreddy.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.harishkumarreddy.springboot.domain.Employee;

@Service
public class LoadBalancerClientConsumeService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	LoadBalancerClient loadBalancerClient;
	
	public String getBaseUrl() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("employee-service");
		String baseUrl = serviceInstance.getUri().toString();
		
		System.out.println("baseUrl : " + baseUrl);
		
		return baseUrl;
	}
	public Employee getEmployeeDetails(int employeeId){
		System.out.println("*************************** Executing from LoadBalancerClientConsumeService ******************");
		String getUrl = getBaseUrl() +"/" + employeeId;
		
		ResponseEntity<Employee> response = restTemplate.getForEntity(getUrl, Employee.class);
		
		return response.getBody();
	}
}
