package com.ncstudy.service.impl;

import com.ncstudy.service.TestThreadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestThreadServiceImpl implements TestThreadService {
    @Override
    @Async("getTaskExecutor")
    public void testAsync() {
        log.info("task start");
        System.out.println("任务启动1");
        System.out.println("任务启动2");
        log.info("task end");
    }
}
