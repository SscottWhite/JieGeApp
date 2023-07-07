package com.ncstudy.control;

import com.ncstudy.service.UserService;
import com.ncstudy.vo.UserVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api
@RestController
@RequestMapping("vue")
@Slf4j
@CrossOrigin
public class VueLoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(path = "success", method=RequestMethod.POST)
	@ResponseBody
   	public UserVo success(@RequestBody UserVo userVo) {
   		System.out.println(userVo.getUsername()+"+"+userVo.getPassword());
   		return new UserVo("1","1","成功");
   	}

	@RequestMapping(path = "success2", method=RequestMethod.POST)
	public void success22(@RequestBody UserVo userVo) {
		System.out.println("进来了没");
		System.out.println(userVo.getUsername()+"+"+userVo.getPassword());
	}

	@PostMapping("success1")
	public void succ(@RequestParam("username") String username){
		System.out.println("success1__"+username );
	}

	@PostMapping("success4")
//	@CrossOrigin("*")
	public String suc2c(@RequestBody UserVo userVo){
		System.out.println("success1__"+userVo.getUsername() );
		return "good";
	}
}
