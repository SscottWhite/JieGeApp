package com.ncstudy.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		Cookie[] cook = req.getCookies();
		for(int i=0;i<cook.length;i++) {
			System.out.println(cook[i]+";"+cook[i].getName()+";"+cook[i].getValue());
		}
	//	if(cook.)
		Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+""); //新建一个cookie
		cookie.setMaxAge(2*60); //设置cookie的有效期
		resp.addCookie(cookie); //响应给客户端一个cookie
		
		//resp.sendRedirect("/login");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req,resp);
	}

}
