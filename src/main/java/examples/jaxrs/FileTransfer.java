package examples.jaxrs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;

/**
 * @author t_endo
 *
 */
public class FileTransfer {

    @Inject
    private Logger logger;

    public void downloadFile() throws IOException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client
                .target("http://localhost:8080/api/examples/file_download");

        try (InputStream in = target.request(MediaType.APPLICATION_JSON).get(
                InputStream.class);
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(in))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                logger.debug("download file: {}", line);
            }
        }
    }
}
