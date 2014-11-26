package examples.cdi;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Qualifier
@Retention(RUNTIME)
@Target({ TYPE, METHOD, FIELD, PARAMETER })
public @interface RequestParameter {

    public String name() default "";
}