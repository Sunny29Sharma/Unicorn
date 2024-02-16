package com.tbh.hackathon.hackathonws.service;

import org.springframework.stereotype.Service;

import com.tbh.hackathon.hackathonws.entity.User;

@Service
public interface UserService {

	public Boolean saveOrUpdateUserPrefrences(User user);
}
