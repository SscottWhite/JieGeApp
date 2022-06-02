package com.ncstudy.config.jwtconfig;

import java.io.IOException;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.ncstudy.pojo.SelfUserEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

/**
 * jwt token 拦截器,  主要验证token 并解析出关键信息
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
		
		log.info("Token过滤器启动:" + tokenHeader);
		
		if(null != tokenHeader && tokenHeader.startsWith(jWTConfig.getTokenPrefix())) {
			try {
				String token = tokenHeader.replace(jWTConfig.getTokenPrefix(), "");
				Claims claims = Jwts.parser()
								.setSigningKey(jWTConfig.getSalt())  //加入密匙解析
								.parseClaimsJws(token)
								.getBody();
				
				String username = claims.getSubject(); //用户名
				String userId = claims.getId();  //用户ID
				
				if(StringUtil.isNotEmpty(username) && StringUtil.isNotEmpty(userId)) {
					List<GrantedAuthority> authorities = new ArrayList<>();					
					String authority = claims.get(jWTConfig.getAuthorities()).toString(); //用户授权
					if(StringUtil.isNotEmpty(authority)) {
						log.info("username的信息:"+username);
						log.info("userId的信息:"+userId);
						log.info("authority的信息:"+authority);
						List<Map<String,String>> authorityMap = JSONObject.parseObject(authority, List.class);
						for(Map<String,String> role : authorityMap) {
							if(!StringUtils.isEmpty(role)) {
								authorities.add(new SimpleGrantedAuthority(role.get("Role_")));
							}
						}
					}
					SelfUserEntity selfUserEntity = new SelfUserEntity();
					selfUserEntity.setUserId(Long.parseLong(userId));
					selfUserEntity.setUsername(username);
					selfUserEntity.setAuthorities(authorities);
					log.info("selfUserEntity的信息:"+selfUserEntity.toString());
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(selfUserEntity, userId, authorities);
					
					SecurityContextHolder  
						.getContext()
						.setAuthentication(authentication);
				} 
			} catch (ExpiredJwtException e) {
				e.printStackTrace();
				log.info("Token过期");
			}  catch (Exception e) {
				e.printStackTrace();
				log.info("Token无效");
			}	
			
		}	
		chain.doFilter(request, response);
		return ;
	}	
}
