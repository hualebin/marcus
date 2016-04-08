package com.marcus.activeMQ;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class JmsReceiver implements MessageListener {

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		try{
			if(message instanceof TextMessage) {
				System.out.println("消息接收开始---------------");
				System.out.println(((TextMessage) message).getText());
				System.out.println("消息接收结束---------------");
			}else{
				System.out.println("Message Type Not Supported");
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
