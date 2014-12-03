package examples.cdi;

import java.io.Serializable;
import java.util.OptionalInt;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;

/**
 * CDIでロガーを取得するためのプロデューサ
 * 
 * @author t_endo
 */
@Named
@Dependent
public class RequestParameterProducer implements Serializable {

    private static final long serialVersionUID = 1424981643941504251L;

    @Inject
    private Logger logger;

    @Inject
    private FacesContext facesContext;

    @Produces
    @RequestParameter
    public OptionalInt getRequestParameter(InjectionPoint ip) {
        RequestParameter annotation = ip.getAnnotated().getAnnotation(
                RequestParameter.class);
        if (annotation == null) {
            logger.warn("annotation not given.");
            return OptionalInt.empty();
        }

        String name = annotation.name();
        if ("".equals(name)) {
            name = ip.getMember().getName();
        }

        String value = facesContext.getExternalContext()
                .getRequestParameterMap().get(name);

        logger.debug("produce RequestParameter ({} = {})", name, value);
        return (value == null) ? OptionalInt.empty() : OptionalInt.of(Integer
                .valueOf(value));
    }
}