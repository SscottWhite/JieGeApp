package com.ncstudy.mapper;

import org.mapstruct.Mapper;

import com.ncstudy.pojo.User;

@Mapper
public interface UserMapper {

	User getUser();
	
	int saveUser(User user);
}
