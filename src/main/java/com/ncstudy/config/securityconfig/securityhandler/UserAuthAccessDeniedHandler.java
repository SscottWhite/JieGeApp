package com.ncstudy.config.securityconfig.securityhandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.ncstudy.toolutils.ResultUtil;

/**
 * 权限处理器
 * @author KJS_352
 *
 */
@Component
public class UserAuthAccessDeniedHandler implements AccessDeniedHandler{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		ResultUtil.responseJson(response, ResultUtil.resultCode(403, "么有权限"));
	}

}
