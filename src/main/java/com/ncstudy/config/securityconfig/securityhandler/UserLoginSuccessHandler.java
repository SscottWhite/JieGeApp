package com.ncstudy.config.securityconfig.securityhandler;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.ncstudy.config.jwtconfig.JWTConfig;
import com.ncstudy.config.jwtconfig.JWTUtil;
import com.ncstudy.pojo.LoginInfo;
import com.ncstudy.pojo.SelfUserEntity;
import com.ncstudy.service.LoginInfoService;
import com.ncstudy.toolutils.ResultUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 登陆成功加入JWT ,返回新的token, 刷新了过期时间
 * @author KJS_352
 * @time 2022-04-21 08:48:54
 */
@Slf4j
@Component
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler{
	
	@Autowired
	private JWTConfig jWTConfig;
	
	@Autowired
	private LoginInfoService  loginInfoService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
										Authentication authentication) throws IOException, ServletException {

		JWTUtil jWTUtil = new JWTUtil();		
		SelfUserEntity selfUserEntity = (SelfUserEntity) authentication.getPrincipal(); //获取主要信息, 就是在验证的时候放进去了
		
		//可以在验证的时候放进去, 也可以在这放进去,只要保证数据是一样的
		//Collection<GrantedAuthority> list1 =  (Collection<GrantedAuthority>) authentication.getAuthorities();

		String token =  jWTConfig.getTokenPrefix() + jWTUtil.createAccessToken(selfUserEntity,jWTConfig); //通过新的信息生成token

		Map<String, Object> map = new HashMap<>();  //返回前端
			map.put("code", "200");
			map.put("msg", "登陆成功");
			map.put(jWTConfig.getTokenHeader(), token);						
		ResultUtil.responseJson(response, map);
		
		//简单保存下
		loginInfoService.saveLoginInfo(
				new LoginInfo(selfUserEntity.getUsername()
							, selfUserEntity.getPassword()
							, new Timestamp(new Date().getTime())
							, token));
	}

}
