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
@Aspect
@Scope
@Order(2)
public class LockAspect2 {
    private static Lock lock = new ReentrantLock();

    //注：execution表达式第一个*表示匹配任意的方法返回值，第二个*表示所有controller包下的类，第三个*表示所有方法,第一个..表示任意参数个数。
    @Pointcut("execution(public * com.ncstudy.control.*.*(..))")
    public void lockAspect(){
    }

    //引用上面的方法
    @Around("lockAspect()")
    public Object around(ProceedingJoinPoint joinPoint){
        lock.lock();
        Object object = null;
        try {
            System.out.println("测前");
            object = joinPoint.proceed();
            System.out.println("测后");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        return object;
    }
}
