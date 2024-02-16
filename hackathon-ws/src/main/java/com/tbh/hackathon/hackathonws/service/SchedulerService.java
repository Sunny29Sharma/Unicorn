package com.tbh.hackathon.hackathonws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@EnableScheduling
@Slf4j
@Component
public class SchedulerService {

	@Autowired
	OrderService orderService;

	@Autowired
	PromotionalService promotionalService;
	
	@Autowired
	DueReminderService dueReminderService;

	@SendTo("/topic/Order")

	@Scheduled(fixedDelay = 6000)
	public void getOrders() {
		int randomWithMathRandom = (int) ((Math.random() * (50000 - 1)) + 1);
		String orderId = "ORDER" + randomWithMathRandom;
		orderService.notifyOrderUpdate(orderId, "Delivered");
	}

	@SendTo("/topic/Promotional")
	@Scheduled(fixedDelay = 12000)
	public void notifyPromotions() {
		System.out.println("from notifyPromotions() ");
		promotionalService.notifyDiscountCoupon("WELCOME");
	}
	
	@SendTo("/topic/Reminder")
	@Scheduled(fixedDelay = 20000)
	public void notifyReminders() {
		int randomWithMathRandom = (int) ((Math.random() * (50000 - 1)) + 1);
		String orderId = "ORDER" + randomWithMathRandom;
		dueReminderService.notifyWhenDueCreatedForCustomer(orderId,"500");
	}
}
