package com.ncstudy.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ncstudy.service.UserService;
import com.ncstudy.vo.UserVo;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;


@Api
@Controller
@RequestMapping("/vue")
@Slf4j
@CrossOrigin
public class VueLoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(path = "/success", method=RequestMethod.POST)
	@ResponseBody
   	public UserVo success(@RequestBody UserVo userVo) {
   		System.out.println(userVo.getUsername()+"+"+userVo.getPassword());
   		return new UserVo("1","1","成功");
   	}
}
