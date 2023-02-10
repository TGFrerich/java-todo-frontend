package com.example.backend.service;

import com.example.backend.model.Todo;
import com.example.backend.repository.TodoRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class TodoService {

    private final TodoRepository todoRepository;
    private final IdService idService;

    public TodoService(TodoRepository todoRepository, IdService idService){
        this.todoRepository = todoRepository;
        this.idService = idService;

    }
    public Todo addTodo(Todo todo) {
        String id = idService.generateId();
        System.out.println(id);
        Todo todoToAdd = new Todo(id, todo.description(),
                todo.status());
        return todoRepository.addToDo(todoToAdd);

    }

    public Todo getTodoById(String id) {
        return todoRepository.getTodoById(id);
    }

    public Todo putTodo(String id, Todo todo) {
        return todoRepository.putTodo(id, todo);
    }

    public Todo deleteTodo(String id) {
        return todoRepository.deleteTodo(id);
    }
}
