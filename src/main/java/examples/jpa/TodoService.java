package examples.jpa;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * 
 * @author t_endo
 */
@Transactional
public class TodoService {

    @Inject
    private TodoDao todoDao;

    public List<Todo> list() {
        return this.todoDao.findAll();
    }

    public Todo create(String title) {
        Todo todo = new Todo();
        todo.setTitle(title);

        this.todoDao.persist(todo);
        return todo;
    }
}
