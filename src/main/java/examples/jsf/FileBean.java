package examples.jsf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.core.MediaType;

/**
 * ファイルアップロード、ダウンロード画面用のマネージドBean
 * 
 * @author t_endo
 */
@Named
@ViewScoped
public class FileBean implements Serializable {

    private static final long serialVersionUID = -1861554862101524594L;

    public void download() throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext
                .setResponseContentType(MediaType.APPLICATION_OCTET_STREAM);
        externalContext.addResponseHeader("Content-Disposition",
                "attachment; filename=test.txt");
        try (OutputStream out = externalContext.getResponseOutputStream()) {
            out.write("test".getBytes(StandardCharsets.UTF_8));
            out.flush();
            facesContext.responseComplete();
        }
    }
}
