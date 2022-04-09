package com.ncstudy.config;

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
	
   @Autowired
   private	MyUserDetailService myUserDetailService; 
 
   @Override
   protected void configure(HttpSecurity http) throws Exception {
	   // 定制请求的授权规则
	   // 首页所有人可以访问
	   http.authorizeRequests()
	   	   .antMatchers("/").permitAll() //其他页面都要拦截，【需要在最后设置这个】
           .anyRequest().authenticated();
			 // .antMatchers("/hello/**").hasRole("vip1")
			 // .antMatchers("/getLoginQr/**").hasRole("vip2");
		   
	   http.formLogin();           //如果直接用自动规范, 可以不定义下面的user,pass, 会提供你默认的username,password
			   //.usernameParameter("user")
			  // .passwordParameter("pass")
			  // .loginPage("/toLogin")         //都是接口
			   //.loginProcessingUrl("/index"); // 登陆表单提交请求
	   
	   http.csrf().disable();//关闭csrf功能:跨站请求伪造,默认只能通过post方式提交logout请求
	   http.logout().logoutSuccessUrl("/");  //注销成功来到首页
	   //记住我
	   http.rememberMe().rememberMeParameter("remember"); //其实是帮我们添加了cookie
	  // http.formLogin().loginPage("/toLogin"); //把默认的登陆页面指向我们自己的
	   
	   http.httpBasic();
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
   
 //定义认证规则
   @Override
   protected void configure(AuthenticationManagerBuilder build) throws Exception {
      //在内存中定义，也可以在jdbc中去拿....
      //Spring security 5.0中新增了多种加密方式，也改变了密码的格式。
      //要想我们的项目还能够正常登陆，需要修改一下configure中的代码。我们要将前端传过来的密码进行某种方式加密
      //spring security 官方推荐的是使用bcrypt加密方式。
      
	   build.inMemoryAuthentication()
      		 .passwordEncoder(new BCryptPasswordEncoder())
             .withUser("kuangshen").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2")
             .and()
             .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2")
             .and()
             .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
	   
	   
	  // build.userDetailsService(myUserDetailService);
      
   }

//   @Bean
//   public BCryptPasswordEncoder passwordEncoder() {
//       return new BCryptPasswordEncoder();
//   }
//   
	@Override
	public void configure(WebSecurity web) throws Exception {
		
		//静态文件不需要认证
		web.ignoring().antMatchers("/static/**");
	}
   
   
}