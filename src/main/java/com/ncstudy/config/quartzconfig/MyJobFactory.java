package com.ncstudy.config.quartzconfig;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import lombok.extern.slf4j.Slf4j;

/** 
 * 实现任务实例化方式
 * 继承org.springframework.scheduling.quartz.SpringBeanJobFactory
*/
@Slf4j
public class MyJobFactory   extends   SpringBeanJobFactory  implements  ApplicationContextAware {

    private transient AutowireCapableBeanFactory beanFactory;

    @Override
    public void setApplicationContext(final ApplicationContext context) {
        beanFactory = context.getAutowireCapableBeanFactory();
    }

    /**
     * 	核心
	         * 将job实例交给spring ioc托管
	         * 我们在job实例实现类内可以直接使用spring注入的调用被spring ioc管理的实例
     */
    @Override
    protected Object createJobInstance(final TriggerFiredBundle bundle) throws Exception {
        final Object job = super.createJobInstance(bundle);
        /**
         * 	将job实例交付给spring ioc
         */
      //  log.info("将job实例交付给spring ioc");   //每个任务执行时都会执行
        beanFactory.autowireBean(job);
        return job;
    }
}