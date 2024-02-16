package com.tbh.hackathon.hackathonws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tbh.hackathon.hackathonws.entity.User;


@Repository
public interface UserPrefrenceRepo extends JpaRepository<User,Long> {
	
	User findByUserId(Long usrId);
	
}
