package com.ncstudy.config.jwtconfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	public JWTAuthenticationTokenFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String tokenHeader = request.getHeader("");
		if(null != tokenHeader && tokenHeader.startsWith("")) {
			try {
				String token = tokenHeader.replace("", "");
				Claims claims = Jwts.parser()
								.setSigningKey("")
								.parseClaimsJws(token)
								.getBody();
				
				String username = claims.getSubject();
				String userId = claims.getId();
				
				if(StringUtil.isNotEmpty(username) && StringUtil.isNotEmpty(userId)) {
					List<GrantedAuthority> authorities = new ArrayList<>();
					
					String authority = claims.get("authorities").toString();
					if(StringUtil.isNotEmpty(authority)) {
						List<Map<String,String>> authorityMap = JSONObject.parseObject(authority, List.class);
						for(Map<String,String> role : authorityMap) {
							if(!StringUtils.isEmpty(role)) {
								authorities.add(new SimpleGrantedAuthority(role.get("")));
							}
						}
					}
					SelfUserEntity selfUserEntity = new SelfUserEntity();
					selfUserEntity.setUserId(Long.parseLong(userId));
					selfUserEntity.setUsername(username);
					selfUserEntity.setAuthorities(authorities);
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(selfUserEntity, userId, authorities);
					SecurityContextHolder.getContext().setAuthentication(authentication);
				} 
			} catch (ExpiredJwtException e) {
				log.info("Token过期");
			} catch (Exception e) {
				log.info("Token无效");
			}
		}	
		chain.doFilter(request, response);
		return ;
	}	
}
