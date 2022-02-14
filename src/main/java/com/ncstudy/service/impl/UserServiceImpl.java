package com.ncstudy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

	@Transactional
	public int saveUser(User user) {
		
		return userMapper.saveUser(user);
	}


	@Transactional
	public int updateUser() {
		
		return userMapper.updateUser();
	}

	@Transactional
	public int deleteUser() {
		
		return userMapper.deleteUser();
	}

	@Override
	public PageInfo<User> getUserList(int num, int size) {
		
//		PageHelper.startPage(num, size);
//		List<User> list = userMapper.getUserList();
//		//PageHelper.count(() -> userMapper.getUserList());
//		PageInfo<User> pageInfo = new PageInfo<User>(list);
		
		//就是通过sql干涉，帮你加上limit ?,?
		PageInfo<User> pageInfo = PageHelper
					.startPage(num, size)
					.doSelectPageInfo(() -> userMapper.getUserList());
		
		return pageInfo;
	}

	@Override
	public PageInfo<User> getUserByName(String name) {
		
		PageInfo<User> pageInfo = PageHelper.startPage(1, 1).doSelectPageInfo(() -> userMapper.getUserByName(name));
		return pageInfo;
	}

}
