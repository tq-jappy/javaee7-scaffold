package examples.jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * TODO: BaseDaoを作って共通処理はそちらに実装
 * 
 * @author t_endo
 */
@Stateless
public class TodoDao {

    @Inject
    private EntityManager em;

    @SuppressWarnings("unchecked")
    public List<Todo> findAll() {
        Query query = em.createQuery("SELECT e FROM Todo e");
        List<Todo> list = (List<Todo>) query.getResultList();
        return list;
    }

    public Todo persist(Todo todo) {
        em.persist(todo);
        return todo;
    }

    public Todo edit(Todo todo) {
        em.merge(todo);
        return todo;
    }

    public void remove(Todo todo) {
        em.remove(todo);
    }
}
