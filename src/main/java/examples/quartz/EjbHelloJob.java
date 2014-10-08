package examples.quartz;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;

import examples.ejb.HelloEjb;

/**
 * テスト用のJob。<br />
 * ジョブ実行時にDIされたEJBの呼び出しができるかの確認用。
 * 
 * @author t_endo
 */
public class EjbHelloJob implements Job {

    @Inject
    private Logger logger;

    @EJB
    private HelloEjb hello;

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        logger.info("quartz hello job invoked: {}", hello.greet("quartz"));
    }
}
