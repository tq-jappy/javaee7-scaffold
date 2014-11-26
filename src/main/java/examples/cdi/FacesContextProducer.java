package examples.cdi;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * CDIでロガーを取得するためのプロデューサ
 * 
 * @author t_endo
 */
@Named
@Dependent
public class FacesContextProducer {

    @Produces
    // @RequestScoped
    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }
}
