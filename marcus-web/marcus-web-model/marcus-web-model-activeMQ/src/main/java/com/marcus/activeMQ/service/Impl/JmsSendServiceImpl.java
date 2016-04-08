package com.marcus.activeMQ.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.marcus.activeMQ.service.JmsSendService;

@Component
public class JmsSendServiceImpl implements JmsSendService{
	
	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	public void sendMessage(String text) {
		// TODO Auto-generated method stub
		jmsTemplate.convertAndSend(text);
	}

}
