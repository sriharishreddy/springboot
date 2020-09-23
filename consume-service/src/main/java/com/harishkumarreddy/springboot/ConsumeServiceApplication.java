package com.harishkumarreddy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.harishkumarreddy.springboot.domain.Employee;
import com.harishkumarreddy.springboot.service.ConsumeService;

@SpringBootApplication
public class ConsumeServiceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(ConsumeServiceApplication.class, args);
		ConsumeService consumeService = ctx.getBean(ConsumeService.class);
		
		Employee employee_1_details = consumeService.getEmployeeDetails(1);
		
		System.out.println("Employee 1 Details : " + employee_1_details);
		Employee employee_2_details = consumeService.getEmployeeDetails(2);
		
		System.out.println("Employee 2 Details : " + employee_2_details);
		
		Employee emp = new Employee();
		emp.setEmpName("Hari Kumar");
		emp.setSalary(12000.00);
		String response = consumeService.createNewEmployee(emp);
		System.out.println(" New Created Employee Details" + response);
		
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
