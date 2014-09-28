package examples.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import examples.ejb.CalcEjb;

/**
 * 
 * @author t_endo
 */
@Named("calcBean")
@ViewScoped
public class CalcBean implements Serializable {

    private static final long serialVersionUID = 452007777890103957L;

    @EJB
    private CalcEjb calc;

    @Getter
    private List<String> results;

    @Getter
    @Setter
    private int a;

    @Getter
    @Setter
    private int b;

    @PostConstruct
    public void load() {
        results = new ArrayList<>();
    }

    public void calc() {
        int result = calc.add(a, b);
        results.add(String.format("%d + %d = %d", a, b, result));
        reset();
    }

    private void reset() {
        a = b = 0;
    }
}
