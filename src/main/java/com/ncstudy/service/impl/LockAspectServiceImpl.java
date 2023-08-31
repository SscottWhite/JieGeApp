package com.ncstudy.service.impl;

import com.ncstudy.config.interfaceConfig.ServiceLock;
import com.ncstudy.service.LockAspectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LockAspectServiceImpl implements LockAspectService {
    @Override
    @ServiceLock
    @Transactional(rollbackFor = Exception.class)
    public void test1() {
        System.out.println(Thread.currentThread().getName());
    }
}
