package com.ncstudy.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

	@Autowired
	private RedisTemplate redisTemplate;
	

	@RequestMapping("/tmp")
	public void test(){
		String i = "jackson";
		redisTemplate.opsForValue().set("user:name", "jack1");
		redisTemplate.opsForList().leftPush("user:list:",i);
		System.out.println(redisTemplate.opsForValue().get("user:name"));
		System.out.println(redisTemplate.opsForList().range("user:list:", 0, -1));
	}
}
