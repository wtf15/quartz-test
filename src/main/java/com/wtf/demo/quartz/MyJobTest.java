package com.wtf.demo.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author qingmei
 * @date 2019-12-19
 * @desc TODO
 */
public class MyJobTest {
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("jobName1", "group1")
                .usingJobData("job1", "group1")
                .usingJobData("moon",5.21F)
                .build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("triggerName1", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever())
                .build();

        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }

}
