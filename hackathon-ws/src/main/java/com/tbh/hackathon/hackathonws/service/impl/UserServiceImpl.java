package com.tbh.hackathon.hackathonws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tbh.hackathon.hackathonws.entity.User;
import com.tbh.hackathon.hackathonws.repository.UserPrefrenceRepo;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class UserServiceImpl {
	
	@Autowired
	UserPrefrenceRepo usrRepo;
	
	public Boolean saveOrUpdateUserPrefrences(User user) {
		// TODO Auto-generated method stub
		log.error("inside service");
		log.error(""+user.getUserId());
		User userFromDb = usrRepo.findByUserId(user.getUserId());
		
		if(userFromDb==null) {
			log.error("if user is null");
			User newUser = new User();
			newUser.setUserId(user.getUserId());
			newUser.setUserName(user.getUserName());
			newUser.setLogisticsEnabled(user.getLogisticsEnabled());
			newUser.setDueRemainderEnabled(user.getDueRemainderEnabled());
			newUser.setPromotionsEnabled(user.getPromotionsEnabled());
			newUser.setRowstate(1);
			usrRepo.save(newUser);
			
		}else {
			log.error("if user is not null");
			log.error(""+userFromDb.getUserId());
			log.error(""+userFromDb.getId());
			//usr.setId(user.getId());
			if(user.getDueRemainderEnabled()!=null) {
				userFromDb.setDueRemainderEnabled(user.getDueRemainderEnabled());
			}
			if(user.getLogisticsEnabled()!=null) {
				userFromDb.setLogisticsEnabled(user.getLogisticsEnabled());
			}
			if(user.getPromotionsEnabled()!=null) {
				userFromDb.setPromotionsEnabled(user.getPromotionsEnabled());
			}
			usrRepo.save(userFromDb);
		}
		return null;
	}
	
	public List<User> getAllUsers(){
		return usrRepo.findAll();
	}

}
