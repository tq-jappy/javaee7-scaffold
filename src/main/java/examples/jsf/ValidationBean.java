package examples.jsf;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import examples.cdi.Person;

/**
 * CDIのスコープの動作確認Bean
 * 
 * @author t_endo
 */
@Named
@ViewScoped
public class ValidationBean implements Serializable {

    private static final long serialVersionUID = -5079708600748254123L;

    @Inject
    private Person person;

    @PostConstruct
    public void create() {
        // person = new Person();
        person.setName("alice");
        person.setAge(5);
    }

    public void validate() {
    }
}
