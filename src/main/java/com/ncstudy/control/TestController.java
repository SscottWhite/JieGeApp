package com.ncstudy.control;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInfo;
import com.ncstudy.pojo.User;
import com.ncstudy.service.UserService;
import com.ncstudy.vo.PageVo;

import cn.hutool.extra.qrcode.QrCodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api
@Controller
@Slf4j
public class TestController {
		//DI注入数据源
	    @Autowired
	    DataSource dataSource;
	   	
	    @RequestMapping(path="/hello", method=RequestMethod.GET)
	    @ResponseBody
	    public void contextLoads() throws SQLException {
	        //看一下默认数据源
	        System.out.println(dataSource.getClass());
	        //获得连接
	        Connection connection =  dataSource.getConnection();
	        System.out.println(connection);
	
	        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
	        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
	        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());
	
	        //关闭连接
	        connection.close();
	    }
	    
	    @RequestMapping(path="/helloworld", method=RequestMethod.GET)
	    @ResponseBody
	    public String hello() {
	        return "helloworld";
	    }


//		@RequestMapping(path = "/mv", method=RequestMethod.GET)
//	    public ModelAndView test2() {
//	        ModelAndView mv=new ModelAndView();
//	        mv.addObject("msg","Hello , SpringBoot!!!");
//	        mv.setViewName("index");
//	        return mv;
//	    }
//	 
//	    @RequestMapping(path = "/model", method=RequestMethod.GET)
//	    public String test3(Model model) {
//	        model.addAttribute("msg","Hello , World!!!");
//	        return "index";
//	    }
//	    
//	    @RequestMapping(path = "/getUser", method=RequestMethod.POST)
//	    public String getUser(Model model, @RequestParam("name") String name, @RequestParam("password") String password) {
//	    	//User user = userService.getUser();
//	    	System.out.println(name+";"+password);
//	    	//User user = userService.getUserByName(name).getList().get(0);
//	    	//int i = userService.saveUser(new User("locl",12,"goog","男"));
//	    	//log.info("序号:" + i);
//	        model.addAttribute("msg",name);
//	        return "index";
//	    }
//	    
//	    @RequestMapping(path = "/updateUser", method=RequestMethod.GET)
//	    public String updateUser(Model model) {
//	    	User user = userService.getUser();
//	    	int i = userService.updateUser();
//	    	log.info("序号:" + i);
//	        model.addAttribute("msg",user.getName());
//	        return "index";
//	    }
//	    
//	    @RequestMapping(path = "/deleteUser", method=RequestMethod.GET)
//	    public String deleteUser(Model model) {
//	    	User user = userService.getUser();
//	    	int i = userService.deleteUser();
//	    	log.info("序号:" + i);
//	        model.addAttribute("msg",user.getName());
//	        return "index";
//	    }
//	    
//	    @RequestMapping(path = "/pages", method=RequestMethod.GET)
//	    public String getUserByPages(Model model) {
//	    	PageVo vo = new PageVo(1,20);
//	    	PageInfo<User> pages = userService.getUserList(-1,4);
//	    	System.out.println(pages.getList().toString());
//	        model.addAttribute("msg",pages.getList().get(0).getName());
//	        return "index";
//	    }
	    
	    @RequestMapping(value = "/getLoginQr" ,method = RequestMethod.GET)
	    public void createCodeImg(HttpServletRequest request, HttpServletResponse response){
	        response.setHeader("Pragma", "No-cache");
	        response.setHeader("Cache-Control", "no-cache");	 
	        response.setDateHeader("Expires", 0);
	        response.setContentType("image/jpeg");	 
	        try {
	            //这里没啥操作 就是生成一个UUID插入 数据库的表里
	            //String uuid = userService.createQrImg();
	            response.setHeader("uuid", "123");
	            // 这里是开源工具类 hutool里的QrCodeUtil 
	            // 网址：http://hutool.mydoc.io/
	            QrCodeUtil.generate("123", 300, 300, "jpg",response.getOutputStream());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}