package examples.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import examples.Progress;

/**
 * @author t_endo
 *
 */
@FacesConverter(forClass = Progress.class)
public class ProgressConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component,
            String value) {
        return Progress.of(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent context,
            Object value) {
        return String.valueOf(((Progress) value).getValue());
    }
}
