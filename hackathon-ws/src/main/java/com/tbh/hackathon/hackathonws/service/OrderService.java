package com.tbh.hackathon.hackathonws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.tbh.hackathon.hackathonws.chat.BusinessEvent;

import lombok.AllArgsConstructor;

@Service

public class OrderService {
	
	private final SimpMessagingTemplate messagingTemplate;
	
	@Autowired
	public OrderService(SimpMessagingTemplate messagingTemplate) {
		this.messagingTemplate = messagingTemplate;
	}
	
	public void notifyOrderUpdate(String orderId, String status) {
		
		BusinessEvent event = new BusinessEvent();
		event.setType("Order");
		event.setContent(" Hurray!! Your Order "+ orderId+" is "+status);
		messagingTemplate.convertAndSend("topic/Order", event);
	}
}
