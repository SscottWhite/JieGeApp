package com.ncstudy;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test2(){

        List<String> list = new ArrayList<>();
        list.add("jack");list.add("rose");

        BoundListOperations boundListOperations = redisTemplate.boundListOps("test:list1");
        //boundListOperations.leftPushAll(list);
        System.out.println(boundListOperations.size());
        List list2 = boundListOperations.range(0,boundListOperations.size());//redisTemplate.opsForList().range("test:list1",0,boundListOperations.size());
        List list3 = new ArrayList(list2);
       // System.out.println(boundListOperations.index(1L));
    }

}
