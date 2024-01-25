package com.ncstudy.config.redisconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

//@Configuration
public class JedisConfiguration {

    /**
     * 注入spirng中的读取redis配置的类
     */
//    @Autowired
//    private RedisProperties properties;
//
//    @Bean
//    public JedisPool getJedisPool() {
//        JedisPoolConfig config = new JedisPoolConfig();
//        config.setMaxIdle(properties.getJedis().getPool().getMaxIdle());
//        config.setMaxTotal(properties.getJedis().getPool().getMaxActive());
//        config.setMaxWaitMillis(properties.getJedis().getPool().getMaxWait().toMillis());
//        JedisPool pool = new JedisPool(config, properties.getHost(), properties.getPort(),
//                Integer.valueOf(Long.toString(properties.getTimeout().getSeconds())));
//        return pool;
//    }
}