package com.ncstudy.config.jwtconfig;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

import com.ncstudy.pojo.SelfUserEntity;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import com.alibaba.fastjson.JSON;

public class JWTTokenUtil {
	
	private static final long EXPIRE_TIME= 15*60*1000;
	
    private static final String TOKEN_SECRET="token123";  //密钥盐
	
	public static String createAccessToken(SelfUserEntity selfUserEntity){
        // 登陆成功生成JWT
        String token = Jwts.builder()
                // 放入用户名和用户ID
                .setId(selfUserEntity.getUserId()+"")
                // 主题
                .setSubject(selfUserEntity.getUsername())
                // 签发时间
                .setIssuedAt(new Date())
                // 签发者
                .setIssuer("white")
                // 自定义属性 放入用户拥有权限
                .claim("authorities", JSON.toJSONString(selfUserEntity.getAuthorities()))
                // 失效时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                // 签名算法和密钥
                .signWith(SignatureAlgorithm.HS512, TOKEN_SECRET)
                .compact();
        return token;
    }
}
