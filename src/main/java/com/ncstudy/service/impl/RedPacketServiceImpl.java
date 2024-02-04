package com.ncstudy.service.impl;

import com.ncstudy.service.RedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class RedPacketServiceImpl implements RedPacketService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void sendRedPacket(String redPacketId, double totalAmount, int totalPeople) {
        double remainingAmount = totalAmount;
        for (int i = 1; i < totalPeople; i++) {
            double randomAmount = Math.random() * remainingAmount / (totalPeople - i);
            redisTemplate.opsForList().leftPush(redPacketId, String.format("%.2f", randomAmount));
            remainingAmount -= randomAmount;
        }
        redisTemplate.opsForList().leftPush(redPacketId, String.format("%.2f", remainingAmount));
    }

    @Override
    public String grabRedPacket(String redPacketId) {
        String amount = redisTemplate.opsForList().rightPop(redPacketId);
        if (amount != null) {
            double grabbedAmount = Double.parseDouble(amount);
            String userId = "User" + System.nanoTime();
            String grabInfo = userId + " 抢到了 " + String.format("%.2f", grabbedAmount) + " 元";
            redisTemplate.opsForList().leftPush("grabbed:" + redPacketId, grabInfo);
            return grabInfo;
        } else {
            return "红包已抢完";
        }
    }

    @Override
    public String grabRedPacket(String redPacketId, String userId) {
        String redPacketKey = redPacketId;
        String userKey = "user:" + userId;

        // 使用分布式锁
        boolean isLocked = stringRedisTemplate.opsForValue().setIfAbsent(userKey, "1");
        if (isLocked) {
            // 获取到锁，可以继续抢红包

            if (stringRedisTemplate.opsForList().size(redPacketKey) > 0) {
                // 红包池还有红包，可以继续抢
                String redPacket = stringRedisTemplate.opsForList().leftPop(redPacketKey);
                // 记录抢红包信息
                String record = userId + " 抢到了 " + redPacket + " 元";
                stringRedisTemplate.opsForList().leftPush("red_packet_records:" + redPacketId, record);

                // 释放用户锁
                stringRedisTemplate.delete(userKey);

                return record;
            } else {
                // 红包池已空
                stringRedisTemplate.delete(userKey);
                return "红包已抢光";
            }
        } else {
            // 用户未成功获取锁，表示用户已经抢过红包
            return "你已经抢过红包了";
        }
    }

    @Override
    public String grabRedPacket2(String redPacketId, String userId) {
        String redPacketKey = redPacketId;
        String userKey = "user:" + userId;

//        SessionCallback<String> sessionCallback = operations -> {
//            operations.watch(redPacketKey);
//            String redPacket = operations.opsForList().leftPop(redPacketKey);
//            if (redPacket != null) {
//                operations.multi();
//                operations.opsForList().leftPush("red_packet_records:" + redPacketId, userId + " 抢到了 " + redPacket + " 元");
//                operations.exec();
//            }
//            operations.unwatch();
//            return redPacket;
//        };

        String result = "";//redisTemplate.execute(sessionCallback);

        if (result == null) {
            return "红包已抢光";
        } else if (result.equals("")) {
            return "你已经抢过红包了";
        } else {
            return result;
        }
    }

    @Override
    public List<String> getRedPacketRecords(String redPacketId) {
        return redisTemplate.opsForList().range("grabbed:" + redPacketId, 0, -1);
    }
}