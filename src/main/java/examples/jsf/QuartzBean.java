package examples.jsf;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.quartz.SchedulerException;

import examples.quartz.EjbHelloJob;
import examples.quartz.SchedulerService;

/**
 * 
 * @author t_endo
 */
@Named
@ViewScoped
public class QuartzBean implements Serializable {

    private static final long serialVersionUID = 8923363557115798944L;

    @Inject
    private SchedulerService schedulerService;

    public void schedule() throws SchedulerException {
        schedulerService.schedule(EjbHelloJob.class, "job1", "trigger1",
                "group1");
    }
}
