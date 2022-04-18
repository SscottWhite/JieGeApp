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

@Configuration
@EnableWebSecurity // 开启WebSecurity模式
//prePostEnabled属性决定Spring Security在接口前注解是否可用@PreAuthorize,@PostAuthorize等注解,设置为true,会拦截加了这些注解的接口
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
  // @Autowired
 //  private	MyUserDetailService myUserDetailService; 
 
   /**
    * and() 神器
    */
   @Override
   protected void configure(HttpSecurity http) throws Exception {
	   http.formLogin()        // 1, 表单认证, 会有默认登陆界面    
	   				// .loginPage("/toLogin"); //把默认的登陆页面指向我们自己的
				    // .usernameParameter("user")
					// .passwordParameter("pass")
					// .loginProcessingUrl("/index"); // 登陆表单提交请求
	   	   .and()
	   	   .authorizeRequests() // 2 ,授权管理
	   	   		.antMatchers("/").permitAll()   // 拦截路径
	   	        // .antMatchers("/hello/**").hasRole("vip1")
				// .antMatchers("/getLoginQr/**").hasRole("vip2");
	   	   		.anyRequest()	    //2.5 任何请求
	   	   		.authenticated()    /// 3 都要认证
	       .and()
	       .logout()
	       		.logoutSuccessUrl("/")  //注销成功来到首页
	       .and()
	       .rememberMe()
	       		.rememberMeParameter("remember") //其实是帮我们添加了cookie  
	       .and()
	       .httpBasic()
	       .and()
	       .csrf()
	       		.disable();  //关闭csrf功能:跨站请求伪造,默认只能通过post方式提交logout请求
  }
   
//   @Override
//   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//      
//      //在内存中定义，也可以在jdbc中去拿....
//      auth.inMemoryAuthentication()
//             .withUser("kuangshen").password("123456").roles("vip2","vip3")
//             .and()
//             .withUser("root").password("123456").roles("vip1","vip2","vip3")
//             .and()
//             .withUser("guest").password("123456").roles("vip1","vip2");
//   }
//   
//   @Bean
//   public BCryptPasswordEncoder passwordEncoder() {
//       return new BCryptPasswordEncoder();
//   }

   
 //定义认证规则  , 直接加入了密码保护
   @Override
   protected void configure(AuthenticationManagerBuilder build) throws Exception {
      //在内存中定义，也可以在jdbc中去拿....
      //Spring security 5.0中新增了多种加密方式，也改变了密码的格式。
      //要想我们的项目还能够正常登陆，需要修改一下configure中的代码。我们要将前端传过来的密码进行某种方式加密
      //spring security 官方推荐的是使用bcrypt加密方式。
      
	   build.inMemoryAuthentication()
      		 .passwordEncoder(new BCryptPasswordEncoder())
             .withUser("kuangshen")
             		.password(new BCryptPasswordEncoder().encode("123456"))
             		.roles("vip2")
             .and()
             .withUser("root")
             		.password(new BCryptPasswordEncoder().encode("123456"))
             		.roles("vip1","vip2")
             .and()
             .withUser("guest")
             		.password(new BCryptPasswordEncoder().encode("123456"))
             		.roles("vip1");
	   
	   
	  // build.userDetailsService(myUserDetailService);
      
   }

	@Override
	public void configure(WebSecurity web) throws Exception {
		//静态文件不需要认证
		web.ignoring().antMatchers("/static/**");
	} 
}