package com.tbh.hackathon.hackathonws.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.tbh.hackathon.hackathonws.chat.BusinessEvent;

@Service
public class PromotionalService {

	@Autowired
	private  SimpMessagingTemplate messagingTemplate;

	public void notifyDiscountCoupon(String coupon)
	{
		BusinessEvent event = new BusinessEvent();
		event.setType("Reminder");
		event.setContent(" Hey!! Use this coupon "+coupon+" to get discount of Rs.500 on your next order");
		System.out.println(event);
		messagingTemplate.convertAndSend("/topic/Promotional", event);
	}
}
