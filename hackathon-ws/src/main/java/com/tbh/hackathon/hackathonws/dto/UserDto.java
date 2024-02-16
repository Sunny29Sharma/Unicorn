package com.tbh.hackathon.hackathonws.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private Long id;
	private Long userId;
	private String userName;
	private Boolean logisticsEnabled;
	private Boolean promotionsEnabled;
	private Boolean dueRemainderEnabled;

}
