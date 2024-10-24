package com.ncstudy.config;

import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

//@Component
public class TestTrhead1 {

    final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);

    /**
     * 检查(调度线程池)，每秒执行一次，查看订单的缓冲队列是否有 订单记录，则重新加入到线程池
     */
    final ScheduledFuture scheduledFuture = scheduler.scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {
            System.out.println("123");
        }
    }, 0, 1, TimeUnit.SECONDS);
}
