package examples.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
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

    @Getter
    @Setter
    private String c;

    @Getter
    @Setter
    private String d;

    @Getter
    private List<SelectItem> select1;

    @Getter
    private List<SelectItem> select2;

    @PostConstruct
    public void init() {
        select1 = new ArrayList<>();
        select1.add(new SelectItem("A", "A"));
        select1.add(new SelectItem("B", "B"));

        select2 = new ArrayList<>();
    }

    // public void onChange(ValueChangeEvent event) {
    // c = event.getNewValue().toString();
    public void onChange() {
        if (c == null) {
            select2 = Arrays.asList(new SelectItem("NULL", "NULL"));
            return;
        }

        switch (c) {
        case "A":
            select2 = Arrays.asList(new SelectItem("X", "X"));
            break;
        case "B":
            select2 = Arrays.asList(new SelectItem("Y", "Y"));
            break;
        default:
            select2 = Arrays.asList(new SelectItem("Z", "Z"));
            break;
        }
    }

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
