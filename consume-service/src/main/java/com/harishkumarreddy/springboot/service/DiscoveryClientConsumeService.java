package com.harishkumarreddy.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.harishkumarreddy.springboot.domain.Employee;

@Service
public class DiscoveryClientConsumeService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	DiscoveryClient discoveryClient;
	public String getBaseUrl() {
		List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("employee-service");
		ServiceInstance serviceInstance = serviceInstanceList.get(0);
		String baseUrl = serviceInstance.getUri().toString();
		
		System.out.println("baseUrl : " + baseUrl);
		
		return baseUrl;
	}
	public Employee getEmployeeDetails(int employeeId){
		System.out.println("*************************** Executing from DiscoveryClientConsumeService ******************");
		String getUrl = getBaseUrl() +"/" + employeeId;
		
		ResponseEntity<Employee> response = restTemplate.getForEntity(getUrl, Employee.class);
		
		return response.getBody();
	}
}
