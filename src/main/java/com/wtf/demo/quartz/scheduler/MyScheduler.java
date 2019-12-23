package com.wtf.demo.quartz.scheduler;

import com.wtf.demo.quartz.MyJob1;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class MyScheduler {
	public static void main(String[] args) throws SchedulerException {

		// JobDetail
		JobDetail jobDetail = JobBuilder.newJob(MyJob1.class)
				.withIdentity("job1", "group1")
				.usingJobData("wtf","hello world")
				.usingJobData("moon",5.21F)
				.build();

		// Trigger
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("trigger1", "group1")
				.startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(2)
						.repeatForever())
				.build();

		// SchedulerFactory
		SchedulerFactory  factory = new StdSchedulerFactory();

		// Scheduler
		Scheduler scheduler = factory.getScheduler();

		// 绑定关系是1：N
		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.start();
		
	}

}
