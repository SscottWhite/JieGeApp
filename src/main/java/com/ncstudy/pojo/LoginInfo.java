package com.ncstudy.pojo;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class LoginInfo {

	private int id;
	private String userName;
	private String userPassword;
	private Timestamp inTime;
	private String token;
	
	public LoginInfo(String username,String password, Timestamp inTime, String token) {
		this.userName = username;
		this.userPassword = password;
		this.inTime = inTime;
		this.token = token;
	}
}
