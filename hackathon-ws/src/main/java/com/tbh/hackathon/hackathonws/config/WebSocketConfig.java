package com.tbh.hackathon.hackathonws.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws");
		registry.addEndpoint("/ws").withSockJS();// if browser doesnot support it would fall back to sockjs implementation
		 //registry.addEndpoint("/gs-guide-websocket");
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/all", "/specific","topic");// all for to broadcast to all, specific is for only specific users
		//registry.setApplicationDestinationPrefixes("/app");
		
		//registry.enableSimpleBroker("/topic");
		registry.setApplicationDestinationPrefixes("/app");

	}

}
