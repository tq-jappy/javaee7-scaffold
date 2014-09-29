package examples.jpa;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * {@link EntityManager} のプロデューサ。
 * 
 * @author t_endo
 */
@Named
@Dependent
public class EntityManagerProducer {

    @PersistenceContext(unitName = "primary")
    @Produces
    private EntityManager em;
}
