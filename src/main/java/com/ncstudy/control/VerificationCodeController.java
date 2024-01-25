package com.ncstudy.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("code")
public class VerificationCodeController {

    @Autowired
    private RedisTemplate redisTemplate;

    public void changeDateBase(int index){
        //redisTemplate.getConnectionFactory().getConnection().select(index);
        LettuceConnectionFactory jedisConnectionFactory = (LettuceConnectionFactory) redisTemplate
                .getConnectionFactory();
        jedisConnectionFactory.setDatabase(index);
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
    }

    @GetMapping("sendCode")
    @ResponseBody
    public String sendCode(@RequestParam("phone") String phone){
        Random random = new Random();
        //this.changeDateBase(2);
        int randomnumber = random.nextInt(9000)+1000;
        BoundValueOperations boundValueOperations = redisTemplate.boundValueOps(phone);
        boundValueOperations.set(randomnumber,30, TimeUnit.SECONDS);
        return "已发送:"+randomnumber;
    }


    @GetMapping("getCode")
    @ResponseBody
    public boolean getCode(@RequestParam("phone") String phone
            ,@RequestParam("code") int code){
        int randomnumber = 0;
       // this.changeDateBase(2);
        if(redisTemplate.hasKey(phone)){
            BoundValueOperations boundValueOperations = redisTemplate.boundValueOps(phone);
            randomnumber = (int) boundValueOperations.get();
            long expire = redisTemplate.getExpire(phone);
            System.out.println(randomnumber+":  "+expire);
        }
        return code == randomnumber;
    }
}
