package examples.cdi;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * 
 * @author t_endo
 */
@Data
@Named
@Dependent
public class Person implements Serializable {

    private static final long serialVersionUID = -6867141721207957376L;

    @NotNull
    private String name;

    @Min(18)
    @Max(60)
    private int age;
}
