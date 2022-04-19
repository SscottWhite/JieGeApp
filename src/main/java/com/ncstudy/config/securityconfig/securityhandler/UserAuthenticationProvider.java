package com.ncstudy.config.securityconfig.securityhandler;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.ncstudy.pojo.User;
import com.ncstudy.service.UserService;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

/**
 * 这里是验证用户名密码的地方  只要输入后,点击第一步来到这
 * @author KJS_352
 * @time 2022-04-19 14:04:22
 */

@Slf4j
@Component 
public class UserAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private	UserService userService;
		
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = (String) authentication.getPrincipal(); // 用户名
		String password = (String) authentication.getCredentials();// 密码
		User user = userService.getUserByPwd(username, password);
		if(user == null) 
			throw new UsernameNotFoundException("用户名不存在"); 
		if(!new BCryptPasswordEncoder().matches(password, user.getPassword()))
			throw new BadCredentialsException("密码不正确");
		//if(user)
		return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), "123");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
	
}
