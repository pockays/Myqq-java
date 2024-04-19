package com.linq.cool.qqbot.myqq.job.service.impl;

import com.linq.cool.qqbot.myqq.job.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author liuris
 * @create 2024-04-19-17:02
 */
@Slf4j
@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private Scheduler scheduler;

    private CronTrigger trigger;
    @Override
    public void start(String name, String group, String cronExpression, Class<? extends Job> clazz,String GroupId,String Robotqq) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(name, group).usingJobData("GroupId",GroupId).usingJobData("Robotqq",Robotqq).build();
        String triggerName = String.format("trigger_%s", name);
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, group).withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, trigger);
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
    public void update(CronTrigger cronTrigger, String cronExpression) {
        TriggerKey triggerKey = cronTrigger.getKey();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        CronTrigger newTrigger = cronTrigger.getTriggerBuilder().withSchedule(scheduleBuilder).build();
        try {
            scheduler.rescheduleJob(triggerKey, newTrigger);
            log.info("Update cron trigger {} succeeded!", triggerKey.getName());
        } catch (SchedulerException e) {
            e.printStackTrace();
            log.info("Update cron trigger {} failed!", triggerKey.getName());
        }
    }

    @Override
    public CronTrigger getTrigger(){
        return trigger;
    }
}
