package examples.jsf;

import java.io.IOException;
import java.io.Serializable;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;

import org.slf4j.Logger;

import examples.cdi.RequestParameter;
import examples.ejb.HelloEjb;

/**
 * ホーム画面用のマネージドBean
 * 
 * @author t_endo
 */
@Named
@ViewScoped
public class HomeBean implements Serializable {

    private static final long serialVersionUID = 4788702779412422887L;

    @Inject
    private Logger logger;

    @Inject
    private HelloEjb hello;

    @Inject
    @RequestParameter
    private transient OptionalInt hoge;

    @EJB
    private HelloEjb hello2;

    @Getter
    private String message;

    @Getter
    // Lombok
    private String message2;

    private int count;

    @PostConstruct
    public void load() {
        this.message = hello.greet("JSF1");
        this.message2 = hello2.greet("JSF2");

        logger.debug("hoge = {}, fuga = {}", hoge);
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
        logger.debug("next -> websocket.xhtml");

        Flash flash = FacesContext.getCurrentInstance().getExternalContext()
                .getFlash();
        flash.put("message", message);

        return "websocket?faces-redirect=true";
    }

    public void throwException() throws Exception {
        throw new Exception("hogehoge");
    }

    public void throwIOException() throws Exception {
        throw new IOException("hogehoge");
    }
}
