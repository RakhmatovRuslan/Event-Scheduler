package org.bileton.ticketing;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws SchedulerException, InterruptedException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler sched = schedulerFactory.getScheduler();

        // define the job and tie it to our EventStatusJob class
        JobDetail job = newJob(EventStatusJob.class)
                .withIdentity("job1")
                .build();

        // compute a time that is on the next round minute

        Date runTime = DateBuilder.evenMinuteDate(new Date());

        //Trigger the job to run on the next round minute
        CronTrigger trigger = newTrigger()
                .withIdentity("trigger1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                .build();

        sched.scheduleJob(job,trigger);

        sched.start();

    }

}
