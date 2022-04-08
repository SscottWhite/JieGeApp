package com.ncstudy.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 个人权限
 * @author KJS_352
 *
 */
@Service
public class MyUserDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<SimpleGrantedAuthority> list = new ArrayList();
		list.add(new SimpleGrantedAuthority("ROLE_vip2"));
		return new User("kuangshen","123456",list);
	}

}
