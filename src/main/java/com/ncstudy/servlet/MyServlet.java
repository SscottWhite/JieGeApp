package com.ncstudy.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class MyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		Cookie[] cook = req.getCookies();
		for(int i=0;i<cook.length;i++) {
			System.out.println(cook[i]+";"+cook[i].getName()+";"+cook[i].getValue());
		}
		//Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+""); //新建一个cookie
		//cookie.setMaxAge(2*60); //设置cookie的有效期
		
		String name = req.getParameter("name");
    	String pwd  = req.getParameter("password");
    	String flag = req.getParameter("isLogin");
    	System.out.println(name+" / "+pwd+" / "+flag);
    	if ("y".equals(flag)) {
            //创建两个Cookie对象
            Cookie nameCookie = new Cookie("username", name);
            //设置Cookie的有效期为3天
            nameCookie.setMaxAge(60);
            resp.addCookie(nameCookie);
            
            Cookie pwdCookie = new Cookie("password", pwd);
            pwdCookie.setMaxAge(60);           
            resp.addCookie(pwdCookie);
        }
      //  response.sendRedirect("success.jsp");
		//resp.addCookie(cookie); //响应给客户端一个cookie
		
		resp.sendRedirect("logins");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req,resp);
	}

}
