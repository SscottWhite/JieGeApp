package com.ncstudy.control;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.pool.DruidDataSource;
import com.ncstudy.pojo.User;
import com.ncstudy.service.UserService;

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
	    
	    @Autowired
	    private UserService userService;
	
	    @RequestMapping(path="/hello", method=RequestMethod.GET)
	    @ResponseBody
	    public void contextLoads() throws SQLException {
	        //看一下默认数据源
	        System.out.println(dataSource.getClass());
	        //获得连接
	        Connection connection =   dataSource.getConnection();
	        System.out.println(connection);
	
	        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
	        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
	        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());
	
	        //关闭连接
	        connection.close();
	    }

	    @ApiOperation(value = "登陆")
		@RequestMapping(path = "/a", method=RequestMethod.GET)
		public String test1() {
	    	log.info("是登陆");
			return "index";
		}
		
		
		@RequestMapping(path = "/mv", method=RequestMethod.GET)
	    public ModelAndView test2() {
	        ModelAndView mv=new ModelAndView();
	        mv.addObject("msg","Hello , SpringBoot!!!");
	        mv.setViewName("index");
	        return mv;
	    }
	 
	    @RequestMapping(path = "/model", method=RequestMethod.GET)
	    public String test3(Model model) {
	        model.addAttribute("msg","Hello , World!!!");
	        return "index";
	    }
	    
	    @RequestMapping(path = "/getUser", method=RequestMethod.GET)
	    public String getUser(Model model) {
	    	User user = userService.getUser();
	        model.addAttribute("msg",user.getName());
	        return "index";
	    }
}