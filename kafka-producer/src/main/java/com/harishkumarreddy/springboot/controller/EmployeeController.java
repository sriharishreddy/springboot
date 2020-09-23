package com.harishkumarreddy.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harishkumarreddy.springboot.domain.Employee;
import com.harishkumarreddy.springboot.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/send")
	public String sendEmployeeDetails(@RequestBody Employee empployee) {
		employeeService.sendMessage(empployee);
		return "Sent "+ empployee.getEmployeeName() +" Employee Details Successfully...!";
	}
}
