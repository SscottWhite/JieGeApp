package com.ncstudy.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ncstudy.pojo.User;
import com.ncstudy.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api
@Controller
@Slf4j
public class LoginController  {
	
	@Autowired
	private UserService userService;

	@RequestMapping(path = "/logins", method=RequestMethod.GET)
	public ModelAndView logins() { 
		System.out.println("进入login页面");
    	ModelAndView mv = new ModelAndView();
		mv.setViewName("login/logins");
		return mv;
	}
    
   	@RequestMapping(path = "/loginTo", method=RequestMethod.POST)
   	public void test12(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException {
   		System.out.println("进入绑定cookie环节");
   		
   		//先用cookie的数据进入
   		String name = req.getParameter("name");
	    String pwd = req.getParameter("password");
	    String flag = req.getParameter("isLogin");
   		
   		Cookie[] cookies = req.getCookies();
	    String username="";
		String password="";
		for(int i=0; i<cookies.length; i++){
			if("username".equals(cookies[i].getName())){
				username = cookies[i].getValue();
			} else if ("password".equals(cookies[i].getName())){
				password = cookies[i].getValue();
			}
		}	
		User user = userService.getUserByPwd(username, password);
		
		if(user != null) {						
			req.getRequestDispatcher("/success").forward(req, resq);			
		} else {			
			User user2 = userService.getUserByPwd(name, pwd);
			if(user2 != null) {
				if ("y".equals(flag)) {
		            Cookie nameCookie = new Cookie("username", name);
		            //设置Cookie的有效期为3天
		            nameCookie.setMaxAge(60*2);
		            Cookie pwdCookie = new Cookie("password", pwd);
		            pwdCookie.setMaxAge(60*2);
		                   
		            resq.addCookie(nameCookie);
		            resq.addCookie(pwdCookie); 
		        }
				req.getRequestDispatcher("/success").forward(req, resq);
			} else 
				resq.sendRedirect("/errors");
		}	    		

   	}

   	@RequestMapping(path = "/success", method=RequestMethod.POST)
   	public ModelAndView success(HttpServletRequest req, HttpServletResponse resq) {
   		ModelAndView mv = new ModelAndView();
   		mv.addObject("name", req.getAttribute("username"));
		mv.setViewName("login/success");
   		return mv;
   	}
   	
   	@RequestMapping(path = "/errors", method=RequestMethod.GET)
   	public String error(HttpServletRequest req, HttpServletResponse resq) {
   		return "login/error";
   	}
    
}
