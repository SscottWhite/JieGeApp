package com.ncstudy.config.servletconfig;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ncstudy.pojo.User;
import com.ncstudy.service.UserService;

@WebFilter(filterName="test1",urlPatterns= {"/*"})  //urlPatterns= {"/login"})
public class MyFilter implements Filter{
	
	@Autowired
	private UserService userService;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse resp = (HttpServletResponse) response;
		System.out.println("filter dofilter");
//	    String username="";
//		Cookie[] cookies = req.getCookies();
//		for(int i=0; i<cookies.length; i++){
//			if("username".equals(cookies[i].getName())){
//				username = cookies[i].getValue();
//			}
//		}
//		System.out.println(username);
//		if(username == "") {
//			resp.sendRedirect("/logins");
//			return ;
//		}else
			chain.doFilter(req,resp);	  //跳转到下一个filter/ 若是没有， 则到servlet
	}

	@Override
	public void destroy() {
		System.out.println("filter destroy");
	}

}
