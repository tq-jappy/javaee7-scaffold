package examples.integration;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import examples.HelloEjb;
import examples.HelloResource;

/**
 * @author t_endo
 */
@RunWith(Arquillian.class)
public class HelloResourceTest {

    @Inject
    private HelloEjb hello;

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class).addClass(
                HelloResource.class);
        return jar;
    }

    @Test
    public void test() {
        assertThat(hello.greet("arquillian"), is("Hello, arquillian!"));
    }
}
