package com.ncstudy.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ncstudy.pojo.User;

public interface UserService {
     
	User getUser();
	
	int saveUser(User user);
	
	int updateUser();
	
	int deleteUser();
	
	PageInfo<List<User>> getUserList(int num, int size);
	
	PageInfo<User> getUser(String name, int num, int size);
	
	User getUserByPwd(String name, String password);
	
	User getUserByName(String name);
}
