package main.java.com.thecodeschool.springweb.service;

import main.java.com.thecodeschool.springweb.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "thecodeschool", "Learn Spring MVC", new Date(),
                false));
        todos.add(new Todo(2, "thecodeschool", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "thecodeschool", "Learn Hibernate", new Date(),
                false));
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
}