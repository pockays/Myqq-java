package com.linq.cool.qqbot.myqq.job.service;

import org.quartz.*;

/**
 * @author liuris
 * @create 2024-04-19-17:06
 */

public interface JobService {

    public void startbycron(String name, String group, String cronExpression, Class<? extends Job> clazz,String GroupId,String Robotqq) throws SchedulerException;

    public void startbyinterval(String name, String group,int minute, Class<? extends Job> clazz, String GroupId, String Robotqq) throws SchedulerException;

    public void pause(String group, String name);

    public void update(Trigger Trigger, String value);

    public void delete(String jobName, String jobGroup);

    public CronTrigger getCronTrigger();

    public SimpleTrigger getSimpleTrigger();

}
