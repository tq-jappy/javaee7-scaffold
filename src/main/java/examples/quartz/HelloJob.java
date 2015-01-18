package examples.quartz;

import javax.enterprise.context.Dependent;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * テスト用のJob。<br />
 * ただの呼び出しテスト。
 * 
 * @author t_endo
 */
@Dependent
public class HelloJob implements Job {

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        System.out.println("Hello");
    }
}
