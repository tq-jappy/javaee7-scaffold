package examples.jsf;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import examples.ejb.HelloEjb;

/**
 * 
 * @author t_endo
 */
@Named("index")
@ViewScoped
public class IndexBean implements Serializable {

    private static final long serialVersionUID = 4788702779412422887L;

    @Inject
    private HelloEjb hello;

    private String message;

    @PostConstruct
    public void load() {
        this.message = hello.greet("JSF");
    }

    public String getMessage() {
        return message;
    }
}
