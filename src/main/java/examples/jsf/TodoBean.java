package examples.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import examples.jpa.Todo;

/**
 * 
 * @author t_endo
 */
@Named("todoBean")
@ViewScoped
public class TodoBean implements Serializable {

    private static final long serialVersionUID = -2572621774596100922L;

    @Getter
    private List<Todo> todos;

    @Getter
    private Todo todo;

    @PostConstruct
    public void load() {
        todos = new ArrayList<>();
        todos.add(Todo.builder().title("hoge").build());

        todo = new Todo();
    }

    public void addTodo() {
        todos.add(todo);
        todo = new Todo();
    }
}
