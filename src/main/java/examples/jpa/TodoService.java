package examples.jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * ToDo サービス
 * 
 * @author t_endo
 */
@Stateless
@Transactional
public class TodoService {

    @Inject
    private TodoDao todoDao;

    /**
     * 全件のToDoを取得する。
     * 
     * @return 全ToDo
     */
    public List<Todo> findAll() {
        return this.todoDao.findAll();
    }

    /**
     * ToDoを新規に登録する。
     * 
     * @param title
     *            タイトル
     * @return 登録されたToDo
     */
    public Todo create(String title) {
        Todo todo = new Todo();
        todo.setTitle(title);

        this.todoDao.persist(todo);
        return todo;
    }

    /**
     * ToDoの内容を更新する。
     * 
     * @param todo
     *            更新対象
     * @return 更新されたToDo
     */
    public Todo update(Todo todo) {
        this.todoDao.edit(todo);
        return todo;
    }

    /**
     * ToDoを削除する。
     * 
     * @param todo
     *            削除対象
     */
    public void delete(Todo todo) {
        this.todoDao.remove(todo);
    }
}
