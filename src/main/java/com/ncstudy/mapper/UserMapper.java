package com.ncstudy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import com.ncstudy.pojo.User;

@Mapper
public interface UserMapper {

	User getUser();
	
	int saveUser(User user);
	
	int updateUser();
	
	int deleteUser();
	
	//@Param("num") int num   -> #{num}
	List<User> getUserList();
	
	User getUserByName(@Param("name") String name);
	
	User getUserByPwd(@Param("name") String name, @Param("pwd") String password);
	
	List<String> getUserAuthorities(@Param("id") Long id);
}
