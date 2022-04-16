package com.ncstudy.myjobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyJob1 extends QuartzJobBean{

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		this.getMyJob();
	}

	public void  getMyJob() {
		System.out.println("you had myJob!");
	}
}
