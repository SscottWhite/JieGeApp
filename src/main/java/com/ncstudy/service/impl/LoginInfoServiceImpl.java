package com.ncstudy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncstudy.mapper.LoginInfoMapper;
import com.ncstudy.pojo.LoginInfo;
import com.ncstudy.service.LoginInfoService;

@Service
public class LoginInfoServiceImpl implements LoginInfoService {

	@Autowired
	private LoginInfoMapper loginInfoMapper;
	
	@Override
	@Transactional
	public int saveLoginInfo(LoginInfo loginInfo) {
		
		return loginInfoMapper.saveLoginInfo(loginInfo);
	}

}
