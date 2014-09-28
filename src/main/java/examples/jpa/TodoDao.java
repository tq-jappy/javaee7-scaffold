package examples.jpa;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * 
 * @author t_endo
 */
public class TodoDao {

    @Resource
    private EntityManager em;

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

    public Todo remove(Todo todo) {
        em.remove(todo);
        return todo;
    }
}
