package com.harishkumarreddy.springboot.streams;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EmployeeStream {
	
	String OUTPUT = "employee-output";

	@Output(OUTPUT)
	MessageChannel sendEmployeeMessage();

}
