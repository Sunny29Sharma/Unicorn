package com.tbh.hackathon.hackathonws.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tbh.hackathon.hackathonws.dto.UserDto;
import com.tbh.hackathon.hackathonws.entity.User;
import com.tbh.hackathon.hackathonws.service.impl.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/app")
public class UserController {
	
	@Autowired
	private UserServiceImpl service;
	
	public UserController() {
		log.error("inside controller consturctor");
	}
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public String saveUserPrefrences(@RequestBody UserDto usr) {
		System.out.println("inside controller");
		User user = new User();
		user.setId(usr.getId());
		user.setUserId(usr.getUserId());
		user.setUserName(usr.getUserName());
		user.setLogisticsEnabled(usr.getLogisticsEnabled());
		user.setPromotionsEnabled(usr.getPromotionsEnabled());
		user.setDueRemainderEnabled(usr.getDueRemainderEnabled());
		log.error("values from object");
		log.error(""+usr.getId());
		log.error(""+usr.getUserName());
		log.error(""+usr.getUserId());
		service.saveOrUpdateUserPrefrences(user);
		return "info saved";
		
		
	}
	@GetMapping("/returnMeString")
	public String getString() {
		return "hello abcd";
	}
	
	@GetMapping("/getAll")
	public List<User> getAll(){
		return service.getAllUsers();
	}
	
}
