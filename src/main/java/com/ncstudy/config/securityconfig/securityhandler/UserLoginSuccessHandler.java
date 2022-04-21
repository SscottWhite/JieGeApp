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

import com.ncstudy.config.jwtconfig.JWTConfig;
import com.ncstudy.config.jwtconfig.JWTTokenUtil;
import com.ncstudy.pojo.SelfUserEntity;
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
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		SelfUserEntity selfUserEntity = (SelfUserEntity) authentication.getPrincipal();
		String token = JWTTokenUtil.createAccessToken(selfUserEntity);
		token = JWTConfig.tokenPrefix + token;
		Map<String, Object> map = new HashMap<>();
		map.put("code", "200");
		map.put("msg", "登陆成功");
		map.put("token", token);
		ResultUtil.responseJson(response, map);
	}

}
