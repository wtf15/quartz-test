package com.wtf.demo.dynamic.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.wtf.demo.dynamic.util.BaseJob;

public class TestTask2 implements BaseJob {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out
            .println(Thread.currentThread().getName() + " " + sdf.format(date) + " Task2： ----做技术人的指路明灯，职场生涯的精神导师----");
    }
}
