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
	public PageInfo<List<User>> getUserList(int num, int size) {
		
//		PageHelper.startPage(num, size);
//		List<User> list = userMapper.getUserList();
//		//PageHelper.count(() -> userMapper.getUserList());
//		PageInfo<User> pageInfo = new PageInfo<User>(list);
		
		//就是通过sql干涉，帮你加上limit ?,?
		PageInfo<List<User>> pageInfo = PageHelper
					.startPage(num, size)
					.doSelectPageInfo(() -> userMapper.getUserList());
		
		return pageInfo;
	}

	@Override
	public PageInfo<User> getUser(String name, int num , int size) {
		
		PageInfo<User> pageInfo = PageHelper.startPage(num, size).doSelectPageInfo(() -> userMapper.getUserByName(name));
		return pageInfo;
	}

	@Override
	public User getUserByPwd(String name, String password) {
		
		return userMapper.getUserByPwd(name, password);
	}

	@Override
	public User getUserByName(String name) {
		
		return userMapper.getUserByName(name);
	}

	@Override
	public List<String> getUserAuthorities(Long id) {
		
		return userMapper.getUserAuthorities(id);
	}

}
