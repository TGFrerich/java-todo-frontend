package com.example.backend.service;

import com.example.backend.model.Todo;
import com.example.backend.repository.TodoRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;

    }
    public Todo addTodo(Todo todo) {
        Todo todoToAdd = new Todo(todo.description(),
                todo.status());
        todoRepository.addToDo(todoToAdd);
        return todo;
    }
}
