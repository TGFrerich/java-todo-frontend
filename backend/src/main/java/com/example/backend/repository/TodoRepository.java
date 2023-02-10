package com.example.backend.repository;

import com.example.backend.model.Todo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository

public class TodoRepository {

    private Map<String, Todo> todoList = new HashMap<>();


    public Todo addToDo(Todo todo) {

        todoList.put(todo.id(), todo);
        return todo;
    }

    public List<Todo> getTodoList() {
        return todoList.values().stream().toList();
    }

    public Todo getTodoById(String id) {
        return todoList.get(id);
    }

    public Todo putTodo(String id, Todo todo) {
        todoList.put(id, todo);
        return todo;
    }

    public Todo deleteTodo(String id) {
        return todoList.remove(id);
    }
}
