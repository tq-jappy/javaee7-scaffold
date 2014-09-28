package examples.ejb;

import javax.ejb.Stateless;

/**
 * 
 * @author t_endo
 */
@Stateless
public class CalcEjb {

    public int add(int a, int b) {
        return a + b;
    }
}
