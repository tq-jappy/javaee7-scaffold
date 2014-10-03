package examples.quartz;

import javax.ejb.EJB;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import examples.ejb.HelloEjb;

/**
 * テスト用のJob。<br />
 * ジョブ実行時にDIされたEJBの呼び出しができるかの確認用。
 * 
 * @author t_endo
 */
public class EjbHelloJob implements Job {

    @EJB
    private HelloEjb hello;

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        System.out.println(hello.greet("quartz"));
    }
}
