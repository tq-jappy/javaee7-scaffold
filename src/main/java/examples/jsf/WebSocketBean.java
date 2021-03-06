package examples.jsf;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;

/**
 * WebSocket動作確認画面用のマネージドBean
 * 
 * @author t_endo
 */
@Named
@ViewScoped
public class WebSocketBean implements Serializable {

    private static final long serialVersionUID = -5825874006724587581L;

    @Getter
    String message;

    @PostConstruct
    public void load() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext()
                .getFlash();
        this.message = (String) flash.getOrDefault("message", "not found");
    }
}
