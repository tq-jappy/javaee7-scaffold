package examples.quartz;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import examples.ejb.HelloEjb;

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
