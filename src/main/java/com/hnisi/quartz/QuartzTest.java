package com.hnisi.quartz;

import java.text.ParseException;
import java.util.Date;

import org.quartz.CronTrigger;
import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

public class QuartzTest {

	public static void main(String[] args) throws ParseException {
		SchedulerFactory sf = new StdSchedulerFactory();
		//任务执行时间  
//      Date runTime = DateBuilder.evenMinuteDate(new Date());  
        Date runTime = DateBuilder.evenSecondDateAfterNow(); 
        JobDetail jobDetail = JobBuilder.newJob(TestJob.class)  
                .withIdentity("testJob_1", "group_1")  
                .build(); 
        Trigger trigger = TriggerBuilder.newTrigger()//创建一个新的TriggerBuilder来规范一个触发器  
                .withIdentity("trigger_1", "group_1")//给触发器一个名字和组名  
//              .startNow()//立即执行  
                .startAt(runTime)//设置触发开始的时间  
                .withSchedule  
                (  
                    SimpleScheduleBuilder.simpleSchedule()  
                    .withIntervalInSeconds(10)//时间间隔  
                    .withRepeatCount(5)//重复次数（将执行6次）  
                )  
                .build();//产生触发器  
        
        String cronExpression = "0 * * * * ?"; // 每分钟的30s起，每5s触发任务        
        CronTrigger cronTrigger = new CronTriggerImpl("cronTrigger", 
                Scheduler.DEFAULT_GROUP, cronExpression);
        try{
        	//运行容器，使用SchedulerFactory创建Scheduler实例  
        	Scheduler sched = sf.getScheduler(); 
        	sched.scheduleJob(jobDetail, cronTrigger);  
            System.out.println(jobDetail.getKey() + " 运行在: " + runTime);   
              
            sched.start();  
        }catch (Exception e) {
			e.printStackTrace();
		}
        
	}
}
