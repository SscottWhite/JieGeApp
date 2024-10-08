package com.ncstudy.config.quartzconfig;

import javax.sql.DataSource;

import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import lombok.extern.slf4j.Slf4j;

/**
 * 这个类作用和以前的xml配置一样的,  bean就是 <bean> 不过是换成了class, @Configuration 就是起这个作用
 * @author KJS_352
 *
 */
// @Configuration       //注释掉不启动
// @EnableScheduling   //注释掉不启动
@Slf4j
public class QuartzConfiguration {
    /** 
              * 配置任务工厂实例 
     * */
    @Bean
    public JobFactory jobFactory() {
        /*** 采用自定义任务工厂 整合spring实例来完成构建任务*/
        MyJobFactory jobFactory = new MyJobFactory();
        log.info("配置任务工厂实例");
        return jobFactory;
    }

    /**
	     * 配置任务调度器
	     * 使用项目数据源作为quartz数据源
     * @param jobFactory 自定义配置任务工厂
     * @param dataSource 数据源实例
     * @return
     * @throws Exception
     */
    @Bean(destroyMethod = "destroy", autowire = Autowire.NO)
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory, DataSource dataSource) throws Exception {
    	
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        //将spring管理job自定义工厂交由调度器维护
        schedulerFactoryBean.setJobFactory(jobFactory);
        //设置覆盖已存在的任务
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        //项目启动完成后，等待2秒后开始执行调度器初始化
        schedulerFactoryBean.setStartupDelay(10);
        //设置调度器自动运行
        schedulerFactoryBean.setAutoStartup(true);
        //设置数据源，使用与项目统一数据源
        schedulerFactoryBean.setDataSource(dataSource);
        //设置上下文spring bean name
        schedulerFactoryBean.setApplicationContextSchedulerContextKey("applicationContext");
        //设置配置文件位置
        schedulerFactoryBean.setConfigLocation(new ClassPathResource("/quartz.properties"));
        log.info("配置任务调度器");
        return schedulerFactoryBean;
    }
}
