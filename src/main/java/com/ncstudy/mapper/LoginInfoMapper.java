package com.ncstudy.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ncstudy.pojo.LoginInfo;

@Mapper
public interface LoginInfoMapper {
	int saveLoginInfo(LoginInfo loginInfo);
}
