package com.harishkumarreddy.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harishkumarreddy.springboot.domain.Employee;
import com.harishkumarreddy.springboot.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empoyeeService;
	
	//CRUD 
	//Ctrl + Shift + O download all the imports 
	
	//Creating new Employee
	@PostMapping("/create")
	public Employee create(@RequestBody Employee employee) {
		System.out.println("In Create API...");
		empoyeeService.createEmployee(employee);
		return employee;
	}
	
	// Retrive Existing employee from DB
	@GetMapping("/{id}")
	public Optional<Employee> get(@PathVariable int id) {
		System.out.println("Received Employee Id : " + id);
		return empoyeeService.getEmployee(id);
	}
	
	// Update the Existing Employee
	@PutMapping("/update")
	public Employee update(@RequestBody Employee employee) {
		System.out.println("Invoked Update API...");
		return empoyeeService.updateEmployee(employee);
	}
	
	//Delete Employee by Id
	@DeleteMapping("/{id}")
	public int delete(@PathVariable int id) {
		System.out.println("Employee Id to delete from the Database");
		return empoyeeService.deleteEmployee(id);
	}
	
}
