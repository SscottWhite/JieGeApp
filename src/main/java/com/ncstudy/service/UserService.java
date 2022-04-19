package com.ncstudy.service;

import com.github.pagehelper.PageInfo;
import com.ncstudy.pojo.User;

public interface UserService {
     
	User getUser();
	
	int saveUser(User user);
	
	int updateUser();
	
	int deleteUser();
	
	PageInfo<User> getUserList(int num, int size);
	
	PageInfo<User> getUserByName(String name);
	
	User getUserByPwd(String name, String password);
}
