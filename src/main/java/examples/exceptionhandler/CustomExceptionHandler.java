package examples.exceptionhandler;

import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

/**
 * @author t_endo
 *
 */
public class CustomExceptionHandler extends ExceptionHandlerWrapper {

    private ExceptionHandler wrapped;

    private FacesContext facesContext;

    public CustomExceptionHandler(ExceptionHandler exceptionHandler) {
        this.wrapped = exceptionHandler;
        this.facesContext = FacesContext.getCurrentInstance();
    }

    @Override
    public ExceptionHandler getWrapped() {
        return wrapped;
    }

    @Override
    public void handle() {
        Iterator<ExceptionQueuedEvent> i = super
                .getUnhandledExceptionQueuedEvents().iterator();

        while (i.hasNext()) {
            ExceptionQueuedEventContext eventContext = i.next().getContext();
            Throwable t = eventContext.getException();

            if (t instanceof Exception) {
                facesContext = eventContext.getContext();

                try {
                    facesContext.addMessage(null, new FacesMessage(
                            FacesMessage.SEVERITY_FATAL,
                            t.getClass().getName(), t.getMessage()));
                    facesContext.getApplication().getNavigationHandler()
                            .handleNavigation(facesContext, null, "error");

                    // facesContext.getExternalContext().getFlash()
                    // .setKeepMessages(true);
                    // String contextPath = facesContext.getExternalContext()
                    // .getRequestContextPath();
                    // facesContext.getExternalContext().redirect(
                    // contextPath + "/error.jsf");
                    // } catch (IOException e) {
                    // e.printStackTrace();
                } finally {
                    i.remove();
                }
            }
        }
    }
}
