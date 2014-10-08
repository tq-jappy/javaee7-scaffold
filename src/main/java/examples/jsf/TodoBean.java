package examples.jsf;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;

import org.slf4j.Logger;

import examples.jpa.Todo;
import examples.jpa.TodoService;

/**
 * ToDo管理画面用のマネージドBean
 * 
 * @author t_endo
 */
@Named
@ViewScoped
public class TodoBean implements Serializable {

    private static final long serialVersionUID = -2572621774596100922L;

    @Inject
    private Logger logger;

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
        logger.debug("finish todo {}", todo);
        todo.setFinished(true);
        todoService.update(todo);

        todos = todoService.findAll();
    }

    public void delete(Todo todo) {
        logger.debug("delete todo {}", todo);
        todoService.delete(todo);

        todos = todoService.findAll();
    }
}
