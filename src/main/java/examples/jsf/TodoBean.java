package examples.jsf;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import examples.jpa.Todo;
import examples.jpa.TodoService;

/**
 * 
 * @author t_endo
 */
@Named("todoBean")
@ViewScoped
public class TodoBean implements Serializable {

    private static final long serialVersionUID = -2572621774596100922L;

    @Inject
    private TodoService todoService;

    @Getter
    private List<Todo> todos;

    @Getter
    private Todo todo;

    @PostConstruct
    public void load() {
        todos = todoService.findAll();

        todo = new Todo();
    }

    public void create() {
        todoService.create(todo.getTitle());
        todos = todoService.findAll();

        todo = new Todo();
    }

    public void finish(Todo todo) {
        todo.setFinished(true);
        todoService.update(todo);
    }

    public void delete(Todo todo) {
        // TODO: 未実装
    }
}
