package examples;

import javax.ejb.Stateless;

/**
 * 
 * @author t_endo
 */
@Stateless
public class HelloEjb {

    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
