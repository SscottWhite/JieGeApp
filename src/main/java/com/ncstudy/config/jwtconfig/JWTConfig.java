package com.ncstudy.config.jwtconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JWTConfig {
	//密匙key
	public static String secret;
	//TokenKey
	public static String tokenHeader;
	//Token前缀
	public static String tokenPrefix;
	//过期时间
	public static Integer expiration;
	//不需要认证的接口
	public static String antMatchers;
	
}
