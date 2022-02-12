package com.ncstudy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncstudy.mapper.UserMapper;
import com.ncstudy.pojo.User;
import com.ncstudy.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	
	public User getUser() {

		return userMapper.getUser();
	}

}
