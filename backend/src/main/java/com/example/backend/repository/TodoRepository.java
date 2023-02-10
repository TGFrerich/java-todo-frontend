package com.example.backend.repository;

import com.example.backend.model.Todo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository

public class TodoRepository {

    private Map<String, Todo> todoList;

    public TodoRepository(Map<String, Todo> todoList) {
        this.todoList = todoList;
    }

    public Todo addToDo(Todo todo){
        todoList.put(UUID.randomUUID().toString(),todo);
        return todo;
    }
    public String getTodoList(){
        return new String(todoList.toString());
    }
}
