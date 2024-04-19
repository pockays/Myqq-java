package com.linq.cool.qqbot.myqq.job.service;

import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.SchedulerException;

/**
 * @author liuris
 * @create 2024-04-19-17:06
 */

public interface JobService {

    public void start(String name, String group, String cronExpression, Class<? extends Job> clazz,String GroupId,String Robotqq) throws SchedulerException;

    public void pause(String group, String name);

    public void update(CronTrigger cronTrigger, String cronExpression);

    public CronTrigger getTrigger();
}
