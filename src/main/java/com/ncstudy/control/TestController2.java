package com.ncstudy.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api
@Controller
@Slf4j
public class TestController2 {

	@RequestMapping(path = "/login2", method=RequestMethod.GET)
	public ModelAndView test11() {   	
    	ModelAndView mv = new ModelAndView();
		mv.setViewName("login/login_first");
		return mv;
	}
    
   	@RequestMapping(path = "/login3", method=RequestMethod.GET)
   	public String test12() {
   		return "login/login_handler";
   	}

   	@RequestMapping(path = "/success", method=RequestMethod.GET)
   	public String success() {
   		return "login/success";
   	}
   	
   	@RequestMapping(path = "/error1", method=RequestMethod.GET)
   	public String error() {
   		return "login/error";
   	}
    
}
