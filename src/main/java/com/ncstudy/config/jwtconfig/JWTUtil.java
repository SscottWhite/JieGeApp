package com.ncstudy.config.jwtconfig;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;

import com.alibaba.fastjson.JSON;
import com.ncstudy.pojo.SelfUserEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JWTUtil implements Serializable {
	
    private String secret;
    private Long expiration;
    private String header;

 // bug: 加了两个static final 会报错  NoClassDefFoundError,  记录一下
 	//private static final long EXPIRE_TIME = JWTConfig.expiration;
     //private static final String TOKEN_SECRET = JWTConfig.salt;  //密钥盐
 	/**
 	 * 生成token
 	 * @param selfUserEntity
 	 * @param jWTConfig
 	 * @return
 	 */
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
 		 
 		// log.info("看这里:+++"+selfUserEntity.getAuthorities());  
 		 //[ROLE_ADMIN1, ROLE_ADMIN2, ROLE_ADMIN]
 		 
 		// log.info("看这里JSON++++:"+JSON.toJSONString(selfUserEntity.getAuthorities()));  
 		 // [{"authority":"ROLE_ADMIN1"},{"authority":"ROLE_ADMIN2"},{"authority":"ROLE_ADMIN"}]
         return token;
     }
    
    /**
     * 生成token
     */
    private String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + expiration);
        return Jwts.builder()
        		.setClaims(claims)
        		.setExpiration(expirationDate)
        		.signWith(SignatureAlgorithm.HS512, secret)
        		.compact();
    }

    /**
     * 通过token获取授权
     * @param token
     * @return
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
            		.setSigningKey(secret)
            		.parseClaimsJws(token)
            		.getBody();
            
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    
    /**
     * 通过授权生成token
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put("sub", userDetails.getUsername());
        claims.put("created", new Date());
        return generateToken(claims);

    }

    public String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();

        } catch (Exception e) {
            username = null;
        }
        return username;

    }

    /**
     * 是否过期
     * @param token
     * @return
     */
    public Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    public String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put("created", new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
//        JwtUser user = (JwtUser) userDetails;
//        String username = getUsernameFromToken(token);
//        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    	return false;

    }

}