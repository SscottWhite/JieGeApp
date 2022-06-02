package com.ncstudy.config.jwtconfig;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.ncstudy.config.securityconfig.securityhandler.UserLoginFailureHandler;
import com.ncstudy.pojo.SelfUserEntity;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import com.alibaba.fastjson.JSON;

/**
 * JWTToken生成器
 * 加入了包括userId, username, 一些权限和失效时间
 * @author KJS_352
 * @time 2022-04-20 09:21:14
 */
@Slf4j
public class JWTTokenUtil  {
	
	// bug: 加了两个static final 会报错  NoClassDefFoundError,  记录一下
	//private static final long EXPIRE_TIME = JWTConfig.expiration;
    //private static final String TOKEN_SECRET = JWTConfig.salt;  //密钥盐
	
	public  String createAccessToken(SelfUserEntity selfUserEntity,JWTConfig jWTConfig){

	      // 登陆成功生成JWT
		 String  token = Jwts.builder()
	                // 放入用户ID
	                .setId(selfUserEntity.getUserId()+"")
	                // 主题 用户名
	                .setSubject(selfUserEntity.getUsername())
	                // 签发时间
	                .setIssuedAt(new Date())
	                // 签发者
	                .setIssuer(jWTConfig.getAuthor())
	                // 自定义属性 放入用户拥有权限
	                .claim(jWTConfig.getAuthorities(), JSON.toJSONString(selfUserEntity.getAuthorities()))
	                // 失效时间
	                .setExpiration(new Date(System.currentTimeMillis() + jWTConfig.getExpiration()*1000))
	                // 签名算法和密钥  HS512
	                .signWith(SignatureAlgorithm.HS512, jWTConfig.getSalt())  
	                
	                .compact();
        return token;
    }
}
