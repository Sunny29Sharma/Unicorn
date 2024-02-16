package com.tbh.hackathon.hackathonws.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.tbh.hackathon.hackathonws.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MessageController {

	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;
	
	@Autowired
	OrderService orderService;
	/**here we are accepting messages on /application endpoint
	 *  This is actually a sub-destination on the application destination we defined earlier which was /app . This means the client has to send the message to the destination /app/application to reach this handler
	 */
	
	 @MessageMapping("/send/{eventType}")
	 @SendTo("/topic/{eventType}")
	 public BusinessEvent sendEvent(@DestinationVariable String eventType, BusinessEvent event)
	 {
		 //TODO some biz logic based on event
		 //orderService.notifyOrderUpdate("ABC123", "In-Transit");
		 System.out.println("Received event-"+ event);
		// log.atError(event);
		 return event;
	 }
	
}
