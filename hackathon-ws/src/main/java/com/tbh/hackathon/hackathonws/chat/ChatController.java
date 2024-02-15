package com.tbh.hackathon.hackathonws.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		
		return chatMessage;
	}
	
	@MessageMapping("/chat.addUser")
	@SendTo("/topic/public")
	public ChatMessage addUser(@Payload ChatMessage chatMsg , SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMsg.getSender());
		return chatMsg;
	}
		
}