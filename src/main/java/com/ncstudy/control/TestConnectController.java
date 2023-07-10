package com.ncstudy.control;

import com.ncstudy.toolutils.ResultCode;
import com.ncstudy.toolutils.ResultDO;
import com.ncstudy.vo.UserVo;
import org.springframework.web.bind.annotation.*;



@RestController
//@CrossOrigin
public class TestConnectController {
	
	@PostMapping("postbody")
//	@ResponseBody
   	public ResultDO<UserVo> postBody(@RequestBody UserVo userVo) {
   		System.out.println(userVo.getUsername()+"+"+userVo.getPassword());
		ResultDO resultDO = new ResultDO(ResultCode.TRUE,true);
		resultDO.setData(userVo);
   		return resultDO;
   	}

//	@PostMapping("postparam")
//	@ResponseBody
//	public UserVo postParam(@RequestParam("username") String username) {
//		System.out.println(username);
//		return new UserVo("1","1","成功");
//	}

//	@GetMapping("getbody")
//	public void getBody(@RequestBody UserVo userVo) {
//		System.out.println(userVo.getUsername());
//	}


	@GetMapping("getparam")
	public ResultDO<UserVo> getParam(@RequestParam("username") String username){
		System.out.println(username);
		ResultDO resultDO = new ResultDO(ResultCode.TRUE,true);
		resultDO.setData(new UserVo("成功了","2","你成功了"));
		return resultDO;
	}

}
