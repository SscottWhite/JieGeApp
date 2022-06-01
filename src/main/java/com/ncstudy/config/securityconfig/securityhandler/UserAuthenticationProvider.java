package com.ncstudy.config.securityconfig.securityhandler;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.github.pagehelper.util.StringUtil;
import com.ncstudy.config.securityconfig.SelfUserDetailsService;
import com.ncstudy.pojo.SelfUserEntity;
import com.ncstudy.pojo.User;
import com.ncstudy.service.UserService;
import com.ncstudy.toolutils.DES3;

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
	private	SelfUserDetailsService selfUserDetailsService;
	@Autowired
	private	UserService userService;
		
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = (String) authentication.getPrincipal(); // 用户名
		String password = (String) authentication.getCredentials();// 密码
		
		//查询并验证的代码
		SelfUserEntity userEntity = selfUserDetailsService.loadUserByUsername(username); // 为什么要走这一步	
		
		if(userEntity == null) 
			throw new UsernameNotFoundException("用户名不存在"); 
		
		//if(!new BCryptPasswordEncoder().matches(password, userEntity.getPassword()))
		if( !StringUtil.isEmpty(userEntity.getPassword()) || !password.equals(DES3.decryptThreeDESECB(userEntity.getPassword(),DES3.DES3KEY)))
			throw new BadCredentialsException("密码不正确");
		
		if( !StringUtil.isEmpty(userEntity.getStatus()) || "PROHIBIT".equals(userEntity.getStatus())) 
			throw new LockedException("用户被冻结!");
		
		Set<GrantedAuthority> authorities = new HashSet<>();
		
		//这里是加入权限的代码, role_前缀必须加, 但在controller里的话就不用加了
		//List<SysRoleEntity> 
		authorities.add(new SimpleGrantedAuthority("ROLE_"+"ADMIN"));
		
		return new UsernamePasswordAuthenticationToken(userEntity,password,authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
	
}
