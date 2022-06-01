package com.ncstudy.config.securityconfig;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ncstudy.pojo.SelfUserEntity;
import com.ncstudy.pojo.User;
import com.ncstudy.service.UserService;

/**
 * 封装了一个系统数据 UserDetailsService
 * @author KJS_352
 * @time 2022-04-21 10:54:02
 */
@Component
public class SelfUserDetailsService implements UserDetailsService{

	@Autowired
	private UserService userService;
	
	/**
	 * SelfUserEntity这个基础了userDetails
	 */
	@Override
	public SelfUserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userService.getUserByName(username);

		if(user != null) {
			SelfUserEntity selfUserEntity = new SelfUserEntity();
			BeanUtils.copyProperties(user, selfUserEntity);
			return selfUserEntity;
		}
		
		return null;
	}

}
