package com.ncstudy.config.securityconfig.securityhandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.ncstudy.config.jwtconfig.JWTTokenUtil;
import com.ncstudy.pojo.SelfUserEntity;
import com.ncstudy.toolutils.ResultUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.info("登陆成功: "+authentication.getPrincipal());
//		SelfUserEntity selfUserEntity = (SelfUserEntity) authentication.getPrincipal();
//		String token = JWTTokenUtil.createAccessToken(selfUserEntity);
//		
//		Map<String, Object> map = new HashMap<>();
//		map.put("code", "200");
//		map.put("msg", "登陆成功");
//		map.put("token", token);
//		
//		ResultUtil.responseJson(response, map);
	}

}
