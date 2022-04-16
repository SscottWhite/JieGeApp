package com.ncstudy.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;


import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.DateBuilder;
import org.quartz.DateBuilder.IntervalUnit;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuartzManage {

		@Autowired
		private Scheduler scheduler;
		

		@PostConstruct   //这个注释是说项目启动可以直接自动启动
		public void startScheduler() {
			try {
				scheduler.start();			
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		}
		
		 /**
	     * 增加一个job
	     * 
	     * @param jobClass
	     *            任务实现类
	     * @param jobName
	     *            任务名称
	     * @param jobGroupName
	     *            任务组名
	     * @param jobTime
	     *            时间表达式 (这是每隔多少秒为一次任务)
	     * @param jobTimes
	     *            运行的次数 （<0:表示不限次数）
	     */
		public void addJob(Class<? extends QuartzJobBean> jobClass, String jobName,String jobGroupName, 
					int jobTime, int jobTimes) {
			try {
				JobDetail jobDetail = JobBuilder                   //简单构成任务
										.newJob(jobClass)
										.withIdentity(jobName, jobGroupName)
										.build();
				
				Trigger trigger = null;
				
				if( jobTimes < 0 ) {
					trigger = TriggerBuilder
								.newTrigger()
								.withIdentity(jobName, jobGroupName)
								.withSchedule(SimpleScheduleBuilder
												.repeatSecondlyForever(1)  
												.withIntervalInSeconds(jobTime))
								.startNow()
								.build();
				} else {
					trigger = TriggerBuilder
								.newTrigger()
								.withIdentity(jobName, jobGroupName)
								.withSchedule(SimpleScheduleBuilder
												.repeatSecondlyForever(1)
												.withIntervalInSeconds(jobTime)
												.withRepeatCount(jobTimes)) //多了个重复次数
								.startNow()
								.build();
				}
				
				scheduler.scheduleJob(jobDetail, trigger);
				
			} catch (SchedulerException e) {	
				log.info(e.getMessage());
				e.printStackTrace();
			}
		}
		
		/**
	     * 增加一个job
	     * 
	     * @param jobClass
	     *            任务实现类
	     * @param jobName
	     *            任务名称
	     * @param jobGroupName
	     *            任务组名
	     * @param jobTime
	     *            时间表达式 （如：0/5 * * * * ? ）
	     */
		public void addJob(Class<? extends QuartzJobBean> jobClass, String jobName, String jobGroupName,
				String jobTime) {
			try {	
				
			   JobDetail jobDetail = JobBuilder
					  					.newJob(jobClass)
					  					.withIdentity(jobName, jobGroupName)
					  					.build();
			   Trigger trigger = TriggerBuilder
					  				.newTrigger()
					  				.withIdentity(jobName, jobGroupName)
					  				.startAt(DateBuilder.futureDate(1, IntervalUnit.SECOND)) //一秒后执行
					  				.withSchedule(CronScheduleBuilder.cronSchedule(jobTime))
					  				.startNow()
					  				.build();
			  
				scheduler.scheduleJob(jobDetail, trigger);
				
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		}
		

	    /**
	     * 删除任务一个job
	     * 
	     * @param jobName
	     *            任务名称
	     * @param jobGroupName
	     *            任务组名
	     */
		@Deprecated
		public void deleteJob(String jobName,String jobGroupName) {
			
				try {
					scheduler.deleteJob(new JobKey(jobName,jobGroupName));
				} catch (SchedulerException e) {
					e.printStackTrace();
				}
		}
		
		/**
	            *     移除一个任务
	     *
	     * @param jobName          任务名
	     * @param jobGroupName     任务组名
	     * @param triggerName      触发器名
	     * @param triggerGroupName 触发器组名
	     */
		public void removeJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName) {
		
				try {
					TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
					JobKey jobKey = JobKey.jobKey(jobName, jobGroupName);
					scheduler.pauseTrigger(triggerKey);
					scheduler.unscheduleJob(triggerKey);
					scheduler.deleteJob(jobKey);
				} catch (SchedulerException e) {
					e.printStackTrace();
				}
				
		}
	
	 
	    /**
	     * 修改一个任务的触发时间
	     *
	     * @param triggerName      任务名称
	     * @param triggerGroupName 传过来的任务名称
	     * @param time             更新后的时间规则
	     */
	    public void modifyJobTime(String triggerName, String triggerGroupName, String time) {
	        try {
	            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);    //通过触发器名和组名获取TriggerKey
	            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);                //通过TriggerKey获取CronTrigger
	            if (trigger == null) return;
	            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(time);
	            String oldTime = trigger.getCronExpression();
	            if (!oldTime.equalsIgnoreCase(time)) {
	                trigger = (CronTrigger) trigger
	                				.getTriggerBuilder()        //重新构建trigger
	                				.withIdentity(triggerKey)
	                				.withSchedule(scheduleBuilder)
	                				.build();
	                scheduler.rescheduleJob(triggerKey, trigger);                //按新的trigger重新设置job执行
	            }
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }


		
		/**
	     * 暂停一个job
	     * 
	     * @param jobName
	     * @param jobGroupName
	     */
	    public void pauseJob(String jobName, String jobGroupName) {
	        try {
	            JobKey jobKey = JobKey.jobKey(jobName, jobGroupName);
	            //TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroupName);
	            
	            scheduler.pauseJob(jobKey);
	            //scheduler.pauseTrigger(triggerKey);
	        } catch (SchedulerException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    /**
	     * 恢复一个job
	     * 
	     * @param jobName
	     * @param jobGroupName
	     */
	    public void resumeJob(String jobName, String jobGroupName) {
	        try {
	            JobKey jobKey = JobKey.jobKey(jobName, jobGroupName);
	            scheduler.resumeJob(jobKey);
	        } catch (SchedulerException e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * 立即执行一个job
	     * 
	     * @param jobName
	     * @param jobGroupName
	     */
	    public void runAJobNow(String jobName, String jobGroupName) {
	        try {
	            JobKey jobKey = JobKey.jobKey(jobName, jobGroupName);
	            scheduler.triggerJob(jobKey);
	        } catch (SchedulerException e) {
	            e.printStackTrace();
	        }
	    }

	 
	    /**
	   * 获取所有计划中的任务列表
	     * @return
	     */
	    public List<Map<String,Object>> queryAllJob(){
	    	
	    	List<Map<String, Object>> jobList = null;
	    	try {
	    		GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();//job列	    	
				Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
				jobList = new ArrayList<Map<String,Object>>();
				for(JobKey jobKey : jobKeys) {
					List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);//获取触发器
					for(Trigger trigger : triggers) {
						
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("jobName", jobKey.getName());
						map.put("jobGroupName", jobKey.getGroup());
						map.put("description","触发器:"+trigger.getKey());
						
						Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
						map.put("jobStatus",triggerState.name());
						
						if(trigger instanceof CronTrigger) {
							CronTrigger cronTrigger = (CronTrigger) trigger;
							String cronExpression = cronTrigger.getCronExpression();
							map.put("jobTime", cronExpression);
						}
						jobList.add(map);
					}
				}			
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
	    	
	    	return jobList; 
	    }
	    
	    /**
	     * 获取所有正在运行的job
	     * @return
	     */
	   public List<Map<String, Object>> queryRunJob(){
		   
		    List<Map<String, Object>> jobList = null;
		    try {
				List<JobExecutionContext> executingJobs = scheduler.getCurrentlyExecutingJobs();
				jobList = new ArrayList<Map<String, Object>>(executingJobs.size());
				
				for(JobExecutionContext executingJob : executingJobs) {
					Map<String, Object> map = new HashMap<String, Object>();
					JobDetail jobDetail = executingJob.getJobDetail();
					JobKey jobKey = jobDetail.getKey();
					Trigger trigger = executingJob.getTrigger();
					map.put("jobName",jobKey.getName());
					map.put("jobGroupName",jobKey.getGroup());
					map.put("description", "触发器:"+ trigger.getKey());
					
					Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
					map.put("jobStatus", triggerState.name());
					
					if(trigger instanceof CronTrigger) {
						CronTrigger cronTrigger = (CronTrigger) trigger;
						String cronExpression = cronTrigger.getCronExpression();
						map.put("jobTime", cronExpression);
					}
					jobList.add(map);
				}
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		    return jobList;
	   }
		
}
