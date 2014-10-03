package examples.quartz;

import javax.ejb.Stateless;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.JobFactory;
import org.quartz.spi.TriggerFiredBundle;

/**
 * CDIで管理されているJobを生成するための{@link JobFactory}実装。
 * 
 * @author t_endo
 */
@Stateless
public class CdiJobFactory implements JobFactory {

    @Inject
    @Any
    private Instance<Job> jobs;

    @Override
    public Job newJob(TriggerFiredBundle triggerFiredBundle, Scheduler scheduler)
            throws SchedulerException {
        final JobDetail jobDetail = triggerFiredBundle.getJobDetail();
        final Class<? extends Job> jobClass = jobDetail.getJobClass();

        Instance<? extends Job> instance = jobs.select(jobClass);

        if (instance.isAmbiguous()) {
            throw new IllegalStateException(
                    "Failed to provide job (ambiguous):  " + jobClass);
        }

        if (instance.isUnsatisfied()) {
            throw new IllegalStateException(
                    "Failed to provide job (unsatisified):  " + jobClass);
        }

        Job job = instance.get();
        return job;
    }
}
