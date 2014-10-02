package examples.jsf;

import java.io.Serializable;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import examples.ejb.HelloEjb;

/**
 * 
 * @author t_endo
 */
@Named
@ViewScoped
public class IndexBean implements Serializable {

    private static final long serialVersionUID = 4788702779412422887L;

    @Inject
    private HelloEjb hello;

    @EJB
    private HelloEjb hello2;

    @Getter
    private String message;

    @Getter
    private String message2;

    private int count;

    @PostConstruct
    public void load() {
        this.message = hello.greet("JSF1");
        this.message2 = hello2.greet("JSF2");
    }

    public String sayBye() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, ++count).forEach((i) -> {
            sb.append("Bye");
        });
        this.message = sb.toString();

        return null;
    }

    public String gotoWebSocketPage() {
        System.out.println("next -> websocket.xhtml");

        Flash flash = FacesContext.getCurrentInstance().getExternalContext()
                .getFlash();
        flash.put("message", message);

        return "websocket?faces-redirect=true";
    }
}
