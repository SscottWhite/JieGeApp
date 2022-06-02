package com.ncstudy.config.jwtconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JWTConfig {
	//密匙key
	public  String secret;
	//TokenKey
	public  String tokenHeader;
	//Token前缀
	public  String tokenPrefix;
	//过期时间
	public  Integer expiration;
	//不需要认证的接口
	public  String antMatchers;
	//加密盐
	public  String salt;
	
	public  String authorities;
	
	public  String authority;
	
	public  String author;
}
