package com.ncstudy.config.aopConfig;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
@Scope
@Aspect
@Order(1)
public class LockAspect {

    private static Lock lock = new ReentrantLock();

    @Pointcut("@annotation(com.ncstudy.config.interfaceConfig.ServiceLock)")
    public void lockAspect(){
    }

    //引用上面的方法
    @Around("lockAspect()")
    public Object around(ProceedingJoinPoint joinPoint){
        lock.lock();
        Object object = null;
        try {
           // System.out.println("注解 -- 测前");
            object = joinPoint.proceed();
           // System.out.println("注解 -- 测后");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        return object;
    }
}
