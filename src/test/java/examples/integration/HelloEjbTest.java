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

import examples.ejb.HelloEjb;

/**
 * @author t_endo
 */
@RunWith(Arquillian.class)
public class HelloEjbTest {

    @Inject
    private HelloEjb hello;

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class).addClass(
                HelloEjb.class);
        return jar;
    }

    @Test
    public void shouldGreetWithGivenName() {
        assertThat(hello.greet("arquillian"), is("Hello, arquillian!"));
    }
}
