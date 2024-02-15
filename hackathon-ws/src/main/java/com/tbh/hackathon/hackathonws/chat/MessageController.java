package com.tbh.hackathon.hackathonws.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
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
	@MessageMapping("/application")//. in config file, we have give starts with app, sousing application here
	@SendTo("/all/messages")//Next, we forward the incoming message to /all/messages. Now all clients subscribing to the messages on this destination will get the messages intended to be sent to all the clients.
	public HelloMessage send(final HelloMessage msg) throws Exception {
		return msg;
	}
	
	/*@MessageMapping("/hello")
	  @SendTo("/topic/greetings")
	  public Greeting greeting(HelloMessage message) throws Exception {
	    Thread.sleep(1000); // simulated delay
	    return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	  }*/
	
	 @MessageMapping("/private")
	    public void sendToSpecificUser(@Payload HelloMessage message) {
	        simpMessagingTemplate.convertAndSendToUser(message.getTo(), "/specific", message);
	    }
	 
	 @MessageMapping("/send/{eventType}")
	 @SendTo("/topic/{eventType}")
	 public BusinessEvent sendEvent(@DestinationVariable String eventType, BusinessEvent event)
	 {
		 //TODO some biz logic based on event
		 orderService.notifyOrderUpdate("ABC123", "In-Transit");
		 System.out.println("Received event-"+ event);
		// log.atError(event);
		 return event;
	 }
	
}
