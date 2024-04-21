package com.linq.cool.qqbot.myqq.job.service.impl;

import com.linq.cool.qqbot.myqq.job.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static org.quartz.DateBuilder.futureDate;

/**
 * @author liuris
 * @create 2024-04-19-17:02
 */
@Slf4j
@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private Scheduler scheduler;

    private CronTrigger cronTrigger;

    private  SimpleTrigger simpleTrigger;
    @Override
    public void startbycron(String name, String group, String cronExpression, Class<? extends Job> clazz,String GroupId,String Robotqq) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(name, group).usingJobData("GroupId",GroupId).usingJobData("Robotqq",Robotqq).build();
        String triggerName = String.format("trigger_%s", name);
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerName, group).withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
        if (!scheduler.isStarted()) {
            scheduler.start();
        }
    }

    @Override
    public void startbyinterval(String name, String group,int minute, Class<? extends Job> clazz, String GroupId,String Robotqq,boolean overtime) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(name, group).usingJobData("GroupId",GroupId).usingJobData("Robotqq",Robotqq).usingJobData("overtime",overtime).build();
        String triggerName = String.format("trigger_%s", name);
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.repeatMinutelyForever(30);
        simpleTrigger = TriggerBuilder.newTrigger().withIdentity(triggerName, group).startAt(futureDate(minute, DateBuilder.IntervalUnit.MINUTE)).withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, simpleTrigger);
        if (!scheduler.isStarted()) {
            scheduler.start();
        }
    }

    @Override
    public void pause(String group, String name) {
        JobKey jobKey = JobKey.jobKey(name, group);
        try {
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
            log.info("Pause Job with name = {} group = {} failed, system error!",name,group);
        }
    }

    @Override
    public void update(Trigger Trigger, String value) {
        TriggerKey triggerKey= Trigger.getKey();
        Trigger newTrigger;
        if(Trigger instanceof CronTrigger){
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(value);
            newTrigger=cronTrigger.getTriggerBuilder().withSchedule(scheduleBuilder).build();
        }else{
            SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.repeatMinutelyForever(30);
            newTrigger=simpleTrigger.getTriggerBuilder().startAt(futureDate(Integer.parseInt(value), DateBuilder.IntervalUnit.MINUTE)).withSchedule(scheduleBuilder).build();
        }
        try {
            scheduler.rescheduleJob(triggerKey, newTrigger);
            log.info("Update  trigger {} succeeded!", triggerKey.getName());
        } catch (SchedulerException e) {
            e.printStackTrace();
            log.info("Update  trigger {} failed!", triggerKey.getName());
        }
    }

    @Override
    public void delete(String jobName, String jobGroup) {
        try {
            if (!scheduler.deleteJob(JobKey.jobKey(jobName, jobGroup))) {
                log.info("Removing job {} failed!", jobName);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
            log.info("Removing job {} failed with error!", jobName);
        }
    }

    @Override
    public SimpleTrigger getSimpleTrigger(){
        return simpleTrigger;
    }
    @Override
    public CronTrigger getCronTrigger(){ return cronTrigger; };
}
