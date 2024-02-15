package com.tbh.hackathon.hackathonws.config;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.tbh.hackathon.hackathonws.chat.ChatMessage;
import com.tbh.hackathon.hackathonws.chat.MessageType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketEventListener {
	
	//private final SimpMessageSendingOperations messageTemplate;

	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		String username = (String)headerAccessor.getSessionAttributes().get("username");
		if(username != null) {
			/*log.info("User disconnected :" + username);
			var chatMsg = ChatMessage.builder()
					.type(MessageType.LEAVER)
					.sender(username)
					.build();
			
			messageTemplate.convertAndSend("/topic/public", chatMsg);*/
		}
	}
}
