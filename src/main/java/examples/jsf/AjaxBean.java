package examples.jsf;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

/**
 * Ajaxサンプル画面用のマネージドBean
 * 
 * @author t_endo
 */
@Named
@ViewScoped
public class AjaxBean implements Serializable {

    private static final long serialVersionUID = 624943814314972308L;

    @Getter
    @Setter
    private String text;

    @Getter
    private String a = "a0";

    @Getter
    private String b = "b0";

    public void ajaxA() {
        a = text;
        b = text;
    }

    public void ajaxB() {
        a = text;
        b = text;
    }

    public void reset() {
        a = "";
        b = "";
    }
}
