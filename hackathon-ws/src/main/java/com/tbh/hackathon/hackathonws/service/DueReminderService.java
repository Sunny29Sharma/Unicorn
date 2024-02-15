package com.tbh.hackathon.hackathonws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.tbh.hackathon.hackathonws.chat.BusinessEvent;

import lombok.AllArgsConstructor;

@Service
public class DueReminderService {
	
	private final SimpMessagingTemplate messagingTemplate;

	@Autowired
	public DueReminderService(SimpMessagingTemplate messagingTemplate) {
		this.messagingTemplate = messagingTemplate;
	}
	public void notifyWhenDueCreatedForCustomer(String orderId, String amount)
	{
		BusinessEvent event = new BusinessEvent();
		event.setType("Reminder");
		event.setContent(" Request to pay Rs. "+ amount+" pending against your order "+orderId);
		messagingTemplate.convertAndSend("topic/Reminder", event);
	}

}
