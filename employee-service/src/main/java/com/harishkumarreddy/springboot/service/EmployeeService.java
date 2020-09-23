package com.harishkumarreddy.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harishkumarreddy.springboot.domain.Employee;
import com.harishkumarreddy.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	//CRUD
	
	public Employee createEmployee(Employee employee) {
		System.out.println("In service Class");
		employeeRepository.save(employee);
		return employee;
	}
	
	public Optional<Employee> getEmployee(int employeeId) {
		
		return employeeRepository.findById(employeeId);
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public int deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
		return employeeId;
		
	}
}
