package com.harishkumarreddy.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.harishkumarreddy.springboot.domain.Employee;

@Service
public class ConsumeService {
	
	@Autowired
	RestTemplate restTemplate;
	
	public static final String baseUrl = "http://localhost:8080";
	
	public Employee getEmployeeDetails(int employeeId){
		System.out.println("*************************** Executing from ConsumeService ******************");
		String getUrl = baseUrl +"/" + employeeId;
		System.out.println("url : " + getUrl);
		ResponseEntity<Employee> response = restTemplate.getForEntity(getUrl, Employee.class);
		
		return response.getBody();
	}
	
	public String createNewEmployee(Employee employee){
		
		String getUrl = baseUrl +"/create";
		System.out.println("url : " + getUrl);
		ResponseEntity<String> response = restTemplate.postForEntity(getUrl, employee, String.class);
		return response.getBody();
	}
}
