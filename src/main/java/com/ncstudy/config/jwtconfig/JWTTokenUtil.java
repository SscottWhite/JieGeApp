package com.ncstudy.config.jwtconfig;

import java.util.Date;

import com.ncstudy.pojo.SelfUserEntity;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import com.alibaba.fastjson.JSON;

/**
 * JWTToken生成器
 * 加入了包括userId, username, 一些权限和失效时间
 * @author KJS_352
 * @time 2022-04-20 09:21:14
 */
public class JWTTokenUtil {
	
	private static final long EXPIRE_TIME = JWTConfig.expiration;
	
    private static final String TOKEN_SECRET = JWTConfig.salt;  //密钥盐
	
	public static String createAccessToken(SelfUserEntity selfUserEntity){
		String token = "";
		try {
	        // 登陆成功生成JWT
	        token = Jwts.builder()
	                // 放入用户ID
	                .setId(selfUserEntity.getUserId()+"")
	                // 主题 用户名
	                .setSubject(selfUserEntity.getUsername())
	                // 签发时间
	                .setIssuedAt(new Date())
	                // 签发者
	                .setIssuer(JWTConfig.author)
	                // 自定义属性 放入用户拥有权限
	               // .claim(JWTConfig.authorities, JSON.toJSONString(selfUserEntity.getAuthorities()))
	                // 失效时间
	                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME*1000))
	                // 签名算法和密钥  HS512
	                .signWith(SignatureAlgorithm.HS512, TOKEN_SECRET)  
	                
	                .compact();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		} 
        return token;
    }
}
