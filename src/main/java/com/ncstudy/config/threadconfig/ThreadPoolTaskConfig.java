package com.ncstudy.config.threadconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
@Slf4j
public class ThreadPoolTaskConfig {

	@Value("${async.thread.core_pool_size}")
	private int corePoolSize;       		// 核心线程数（默认线程数）
	@Value("${async.thread.max_pool_size}")
	private int maxPoolSize;			    // 最大线程数
	@Value("${async.thread.keep_alive_time}")
	private int keepAliveTime;			// 允许线程空闲时间（单位：默认为秒）
	@Value("${async.thread.queue_capacity}")
	private int queueCapacity;			// 缓冲队列数
	@Value("${async.thread.thread_name_prefix}")
	private String threadNamePrefix; // 线程池名前缀
	
	@Bean(name="getTaskExecutor")
	public ThreadPoolTaskExecutor getTaskExecutor() {

		log.info("start getTaskExecutor");
//		ThreadPoolTaskExecutor  executor = new ThreadPoolTaskExecutor();
		ThreadPoolTaskExecutor  executor = new VisiableThreadPoolTaskExecutor();
		executor.setCorePoolSize(corePoolSize);   
		executor.setMaxPoolSize(maxPoolSize);
		executor.setQueueCapacity(queueCapacity);
		executor.setKeepAliveSeconds(keepAliveTime);
		executor.setThreadNamePrefix(threadNamePrefix);
		// 线程池对拒绝任务的处理策略
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		// 初始化
		executor.initialize();
		return executor;
	}
}
