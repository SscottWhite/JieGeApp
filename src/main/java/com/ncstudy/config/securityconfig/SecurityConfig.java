package com.ncstudy.config.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ncstudy.config.jwtconfig.JWTConfig;
import com.ncstudy.config.securityconfig.securityhandler.JWTAuthenticationTokenFilter;
import com.ncstudy.config.securityconfig.securityhandler.UserAuthAccessDeniedHandler;
import com.ncstudy.config.securityconfig.securityhandler.UserAuthenticationEntryPointHandler;
import com.ncstudy.config.securityconfig.securityhandler.UserAuthenticationProvider;
import com.ncstudy.config.securityconfig.securityhandler.UserLoginFailureHandler;
import com.ncstudy.config.securityconfig.securityhandler.UserLoginSuccessHandler;
import com.ncstudy.config.securityconfig.securityhandler.UserLogoutSuccessHandler;

import lombok.extern.slf4j.Slf4j;


/**
 * 记住两步
 * 1, 用AuthenticationManagerBuilder来验证和构建登陆的全部信息
 * 2, 用HttpSecurity来维护各种情况并处理
 * @author KJS_352
 * @time 2022-04-19 15:51:42
 */
@Slf4j
@Configuration
@EnableWebSecurity // 开启WebSecurity模式
//prePostEnabled属性决定Spring Security在接口前注解是否可用@PreAuthorize,@PostAuthorize等注解,设置为true,会拦截加了这些注解的接口
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private JWTConfig jWTConfig;
	 /**
     * 自定义登录成功处理器   成功
     */
    @Autowired
    private UserLoginSuccessHandler userLoginSuccessHandler;
    /**
     * 自定义登录失败处理器   失败
     */
    @Autowired
    private UserLoginFailureHandler userLoginFailureHandler;
    /**
     * 自定义注销成功处理器    注销成功
     */
    @Autowired
    private UserLogoutSuccessHandler userLogoutSuccessHandler;
    /**
     * 自定义暂无权限处理器     无权限
     */
    @Autowired
    private UserAuthAccessDeniedHandler userAuthAccessDeniedHandler;
    /**
     * 自定义未登录的处理器    未登录
     */
    @Autowired
    private UserAuthenticationEntryPointHandler userAuthenticationEntryPointHandler;
    /**
     * 自定义身份验证  登陆验证
     */
    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;
    
    /**
     * 密码的加密方式
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    /**
     * 自定义不需验证的路径
     */
    @Override
	public void configure(WebSecurity web) throws Exception {
		//静态文件不需要认证
		web.ignoring().antMatchers("/static/**");
	} 
    
    /**
     * 封装用户
     */
    //定义认证规则  , 直接加入了密码保护
    @Override
    protected void configure(AuthenticationManagerBuilder build) throws Exception {
      //在内存中定义，也可以在jdbc中去拿....
      //Spring security 5.0中新增了多种加密方式，也改变了密码的格式。
      //要想我们的项目还能够正常登陆，需要修改一下configure中的代码。我们要将前端传过来的密码进行某种方式加密
      //spring security 官方推荐的是使用bcrypt加密方式。
      
//	   build.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//             .withUser("kuangshen").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2")
//             .and().withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2")
//             .and().withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
	   
	   //虽然可以通过上面的方法验证用户 , 但是不适用
	   //但是数据库的时代怎么能用这简单的方式,  我们直接验证并封装一个用户, 而不是自己写
	   // ****理解这一步, 基本相当于理解了一大半
	   build.authenticationProvider(userAuthenticationProvider);   
	       
    }
	
	 /**
	  * 核心内容, 里面包含了各种情况
	  */
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
		 
		   http.authorizeRequests() // 2 ,授权管理
			   		.antMatchers("/").permitAll()   // 拦截路径
		   	        // .antMatchers("/hello/**").hasRole("vip1")
					// .antMatchers("/getLoginQr/**").hasRole("vip2");
		   	   		.anyRequest()	    //2.5 任何请求
		   	   		.authenticated()    /// 3 都要认证		   	   		
		   	   	.and()			   	   	
			    .httpBasic()
		       		.authenticationEntryPoint(userAuthenticationEntryPointHandler)  //用户认证
		        .and()
	   	   		.formLogin()
			   	   .successHandler(userLoginSuccessHandler)  //正确登陆
			   	   .failureHandler(userLoginFailureHandler)  //失败处理
		   				// 1, 表单认证, 会有默认登陆界面    
		   				// .loginPage("/toLogin"); //把默认的登陆页面指向我们自己的
					    // .usernameParameter("user")
						// .passwordParameter("pass")
						// .loginProcessingUrl("/index"); // 登陆表单提交请求
		       .and()
		       .logout()
		       		.logoutSuccessUrl("/")  //注销成功来到首页
		       		.logoutSuccessHandler(userLogoutSuccessHandler)
		       .and()
		       .exceptionHandling()
		       		.accessDeniedHandler(userAuthAccessDeniedHandler)//无权限的自定义处理类
		       .and()
		       .rememberMe()
		       		.rememberMeParameter("remember") //其实是帮我们添加了cookie  \
		       .and()
		       .cors() //跨域
		       
		       .and()
		       .addFilter(new JWTAuthenticationTokenFilter(authenticationManager(),jWTConfig))
		       
		       .csrf()  
		       		.disable();  //关闭csrf功能:跨站请求伪造,默认只能通过post方式提交logout请求
		   
		   http.headers().cacheControl();
		   
		 //  http.addFilterBefore(new JWTAuthenticationTokenFilter(authenticationManager(),jWTConfig), beforeFilter)
	  }
	   
	//   @Override
	//   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	      
//	      //在内存中定义，也可以在jdbc中去拿....
//	      auth.inMemoryAuthentication()
//	             .withUser("kuangshen").password("123456").roles("vip2","vip3")
//	             .and()
//	             .withUser("root").password("123456").roles("vip1","vip2","vip3")
//	             .and()
//	             .withUser("guest").password("123456").roles("vip1","vip2");
	//   }
	//   
	//   @Bean
	//   public BCryptPasswordEncoder passwordEncoder() {
//	       return new BCryptPasswordEncoder();
	//   }

}