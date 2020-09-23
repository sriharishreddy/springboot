package com.harishkumarreddy.springboot.streams;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface EmployeeStream {
	
	String INPUT = "employee-input";

	@Input(INPUT)
	SubscribableChannel inboundGreetings();

}
