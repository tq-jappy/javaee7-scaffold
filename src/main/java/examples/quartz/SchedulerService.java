package examples.quartz;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.spi.JobFactory;

/**
 * EEコンテナ上でQuartzスケジューラを動作させるためのサービス。
 * 
 * @author t_endo
 */
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Singleton
@Startup
public class SchedulerService {

    private Scheduler scheduler;

    @Inject
    private JobFactory jobFactory;

    @PostConstruct
    public void start() throws SchedulerException {
        System.out.println("scheduler start.");
        scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.setJobFactory(jobFactory);

        scheduler.start();
    }

    public void schedule(Class<? extends Job> jobClass, String jobName,
            String triggerName, String group) throws SchedulerException {
        JobDetail job = newJob(jobClass).withIdentity(jobName, group).build();
        Trigger trigger = newTrigger().withIdentity(triggerName, group)
                .startNow().build();
        scheduler.scheduleJob(job, trigger);
    }

    @PreDestroy
    public void stop() throws SchedulerException {
        System.out.println("scheduler shutdown.");
        scheduler.shutdown();
    }
}