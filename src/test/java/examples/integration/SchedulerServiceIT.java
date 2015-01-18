package examples.integration;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import examples.cdi.LoggerProducer;
import examples.ejb.HelloEjb;
import examples.interceptor.LoggingInterceptor;
import examples.quartz.EjbHelloJob;
import examples.quartz.HelloJob;
import examples.quartz.SchedulerService;

/**
 * 
 * @author t_endo
 */
@RunWith(Arquillian.class)
public class SchedulerServiceIT {

    @Deployment
    public static WebArchive createDeployment() {
        File[] dependencies = Maven
                .resolver()
                .resolve("org.quartz-scheduler:quartz:2.2.1",
                        "org.slf4j:slf4j-api:1.7.2").withoutTransitivity()
                .asFile();

        WebArchive war = ShrinkWrap.create(WebArchive.class)
                .addPackage(SchedulerService.class.getPackage())
                .addClass(HelloEjb.class).addClass(LoggerProducer.class)
                .addClass(LoggingInterceptor.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        war.addAsLibraries(dependencies);

        return war;
    }

    @Inject
    SchedulerService schedulerService;

    @Test
    public void testScheduleJob_startNowTriggers() throws Exception {
        assertThat(schedulerService.getNumberOfJobsExecuted(), is(0));

        schedulerService.schedule(HelloJob.class, "job1", "trigger1", "test");
        schedulerService
                .schedule(EjbHelloJob.class, "job2", "trigger2", "test");

        TimeUnit.SECONDS.sleep(1);

        assertThat(schedulerService.getNumberOfJobsExecuted(), is(2));
    }
}
