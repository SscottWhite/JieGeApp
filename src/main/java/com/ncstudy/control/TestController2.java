package com.ncstudy.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ncstudy.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api
@Controller
@Slf4j
public class TestController2 {
	
	@Autowired
	private UserService userService;

	@RequestMapping(path = "/login2", method=RequestMethod.GET)
	public ModelAndView test11(HttpServletRequest req) { 
		System.out.println("login2 : "+req.getParameter("name"));
    	ModelAndView mv = new ModelAndView();
		mv.setViewName("login/login_first");
		return mv;
	}
    
   	@RequestMapping(path = "/login3", method=RequestMethod.GET)
   	public String test12(HttpServletRequest req) {
   		System.out.println("login3 : "+req.getParameter("name"));
   		return "login/login_handler";
   	}

   	@RequestMapping(path = "/success", method=RequestMethod.GET)
   	public String success(HttpServletRequest req) {
   		System.out.println("success : "+req.getParameter("name"));
   		return "login/success";
   	}
   	
   	@RequestMapping(path = "/error1", method=RequestMethod.GET)
   	public String error(HttpServletRequest req) {
   		System.out.println("error1 : "+req.getParameter("name"));
   		return "login/error";
   	}
    
}
