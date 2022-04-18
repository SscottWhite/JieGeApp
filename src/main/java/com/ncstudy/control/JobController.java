package com.ncstudy.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncstudy.config.quartzconfig.QuartzManage;
import com.ncstudy.myjobs.TestJob;


@RestController
@RequestMapping("/job")
public class JobController {

	@Autowired
    private QuartzManage quartzService;
	
    @RequestMapping("/addjob")
    public void startJob(String type) {
          quartzService.addJob(TestJob.class, "job1", "test", "0/5 * * * * ?");

    }
    
    @RequestMapping("/add/{type}")
    public void startJobType(@PathVariable(name="type") String type) throws ClassNotFoundException {
         quartzService.addJob((Class<? extends QuartzJobBean>) Class.forName("com.ncstudy.myjobs."+type), "job_"+type, "test", "0/5 * * * * ?");
    }
    
    @RequestMapping("/updatejob")
    public void updatejob() {
            quartzService.modifyJobTime("job1", "test", "0/10 * * * * ?");
    }
    
    @RequestMapping("/deletejob")
    public void deletejob() {
            quartzService.removeJob("job1", "test","job1", "test");
    }
    
    @RequestMapping("/pauseJob")
    public void pauseJob() {
            quartzService.pauseJob("job1", "test");
    }
    
    @RequestMapping("/resumeJob")
    public void resumeJob() {
            quartzService.resumeJob("job1", "test");
    }
    
    @RequestMapping("/queryAllJob")
    public Object queryAllJob() {
            return quartzService.queryAllJob();
    }
    

    @RequestMapping("/queryRunJob")
    public Object queryRunJob() {
            return quartzService.queryRunJob();
    }
}
