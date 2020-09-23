package com.harishkumarreddy.springboot.streams.listener;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.Payloads;
import org.springframework.stereotype.Component;

import com.harishkumarreddy.springboot.domain.Employee;
import com.harishkumarreddy.springboot.streams.EmployeeStream;

@Component
public class EmployeeListener {

	@StreamListener(EmployeeStream.INPUT)
	public void receiveEmployeeMessage(@Payloads Employee employee) {
		System.out.println("Received Employee Details : " + employee);
	}
}
