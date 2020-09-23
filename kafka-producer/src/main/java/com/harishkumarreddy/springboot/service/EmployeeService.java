package com.harishkumarreddy.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.harishkumarreddy.springboot.domain.Employee;
import com.harishkumarreddy.springboot.streams.EmployeeStream;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeStream employeeStream;

	public void sendMessage(final Employee empployee) {
		MessageChannel messageChannel = employeeStream.sendEmployeeMessage();
		messageChannel.send(MessageBuilder.withPayload(empployee)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());
	}
}
