package examples.jsf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.ws.rs.core.MediaType;

import lombok.Getter;
import lombok.Setter;

import org.slf4j.Logger;

/**
 * ファイルアップロード、ダウンロード画面用のマネージドBean
 * 
 * @author t_endo
 */
@Named
@ViewScoped
public class FileBean implements Serializable {

    private static final long serialVersionUID = -1861554862101524594L;

    @Inject
    private Logger logger;

    @Getter
    @Setter
    private Part file;

    public void upload() throws IOException {
        logger.info("uploading file: {}", file.getSubmittedFileName());

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                file.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                logger.debug(line);
            }
        }
    }

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
