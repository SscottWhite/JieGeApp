package com.ncstudy.config.securityconfig.securityhandler;

import java.io.IOException;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.ncstudy.config.jwtconfig.JWTConfig;
import com.ncstudy.pojo.SelfUserEntity;
import com.ncstudy.toolutils.ResultUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

/**
 * jwt token 拦截器,  主要验证token 并解析出关键信息
 * 设置重要的 UsernamePasswordAuthenticationToken 信息
 * @author KJS_352
 * @time 2022-04-20 09:20:49
 */
@Slf4j
public class JWTAuthenticationTokenFilter extends BasicAuthenticationFilter{


	private JWTConfig jWTConfig;
	
	public JWTAuthenticationTokenFilter(AuthenticationManager authenticationManager, JWTConfig jWTConfig) {
		super(authenticationManager);
		this.jWTConfig = jWTConfig;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String tokenHeader = request.getHeader(jWTConfig.getTokenHeader());  //获取 Authorization对应的 value
		
		log.info("Token过滤器启动");
		
		if(null != tokenHeader && tokenHeader.startsWith(jWTConfig.getTokenPrefix())) {
			try {
				String token = tokenHeader.replace(jWTConfig.getTokenPrefix(), "");  //1 去除前缀
				
				Claims claims = Jwts.parser()
								.setSigningKey(jWTConfig.getSalt())  //2 加入密匙解析
								.parseClaimsJws(token)
								.getBody();
				
				String username = claims.getSubject(); //用户名
				String userId = claims.getId();  //用户ID

				if(StringUtil.isNotEmpty(username) && StringUtil.isNotEmpty(userId)) {
					List<GrantedAuthority> authorities = new ArrayList<>();					
					String authority = claims.get(jWTConfig.getAuthorities()).toString(); //用户授权
					if(StringUtil.isNotEmpty(authority)) {
						
						List<Map<String,String>> authorityMap = JSONObject.parseObject(authority, List.class);
						if(authorityMap == null) {
							authorities.add(new SimpleGrantedAuthority("visitor"));
						} else {
							for(Map<String,String> role : authorityMap) {
								if(!StringUtils.isEmpty(role)) {
									authorities.add(new SimpleGrantedAuthority(role.get(jWTConfig.getAuthority())));  //"authority"
									//这个要注意, 前面生成token的时候, 用json 会生成前缀, 所以这边要通过前缀获取
									//[{"authority":"ROLE_ADMIN1"},{"authority":"ROLE_ADMIN2"},{"authority":"ROLE_ADMIN"}]
								}
							}
						}
					}
					SelfUserEntity selfUserEntity = new SelfUserEntity();
					selfUserEntity.setUserId(Long.parseLong(userId));
					selfUserEntity.setUsername(username);
					selfUserEntity.setAuthorities(authorities);
					UsernamePasswordAuthenticationToken authentication 
						= new UsernamePasswordAuthenticationToken(selfUserEntity, userId, authorities);
					
					SecurityContextHolder  
						.getContext()
						.setAuthentication(authentication);
					
					log.info("解析token完成:"+authentication.toString());
				} 
			} catch (ExpiredJwtException e) {
			//	e.printStackTrace();
				String fullStack = ExceptionUtils.getStackTrace(e);
	            log.error("Token过期:"+ fullStack);
	            Map<String, Object> map = new HashMap<>();  //返回前端
				map.put("Token过期", fullStack);
				ResultUtil.responseJson(response,ResultUtil.resultError(map));			

			}  catch (Exception e) {
			//	e.printStackTrace();
				String fullStack = ExceptionUtils.getStackTrace(e);
	            log.error("Token无效:"+ fullStack);
	            Map<String, Object> map = new HashMap<>();  //返回前端
				map.put("Token无效", fullStack);
				ResultUtil.responseJson(response,ResultUtil.resultError(map));		
			}	
			
		}	
		chain.doFilter(request, response);
		return ;
	}	
}
