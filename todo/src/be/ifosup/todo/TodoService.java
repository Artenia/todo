package be.ifosup.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo("Apprendre le Java","Formations"));
        todos.add(new Todo("Préparer un steack","Formations"));
        todos.add(new Todo("Manger le steack","Slurp"));
    }

    public List<Todo> recupereTodo(){
        return todos;
    }

    public void ajouteTodo (Todo todo){
        todos.add(todo);
    }

    public void supprimeTodo (Todo todo){
        todos.remove(todo);
    }

}
