package com.ncstudy;

import com.ncstudy.myjobs.TestJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestQuartz {

    @Autowired
    private Scheduler scheduler;

    @Test
    public void testQ() throws SchedulerException, InterruptedException {
        JobDetail jobDetail = JobBuilder
                .newJob(TestJob.class)
                .storeDurably()
                .withIdentity("detail_name", "detail_group_name")
                .build();

        Trigger trigger1 = TriggerBuilder
                .newTrigger()
                .forJob(jobDetail)
                .withIdentity("trigger1_name", "trigger1_group_name")
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever())
                .startNow()
                .build();

        Trigger trigger2 = TriggerBuilder
                .newTrigger()
                .forJob(jobDetail)
                .withIdentity("trigger2_name", "trigger2_group_name")
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .startNow()
                .build();

        scheduler.addJob(jobDetail, false);
        scheduler.scheduleJob(trigger1);
        scheduler.scheduleJob(trigger2);

        scheduler.start();

        TimeUnit.SECONDS.sleep(20);
        scheduler.shutdown();
    }
}
