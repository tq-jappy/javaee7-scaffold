package examples.jsf;

import java.io.Serializable;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import examples.ejb.HelloEjb;

/**
 * 
 * @author t_endo
 */
@Named("indexPage")
@ViewScoped
public class IndexBean implements Serializable {

    private static final long serialVersionUID = 4788702779412422887L;

    @Inject
    private HelloEjb hello;

    private String message;

    private int count;

    @PostConstruct
    public void load() {
        this.message = hello.greet("JSF");
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
        return "websocket.xhtml";
    }

    public String getMessage() {
        return message;
    }
}
