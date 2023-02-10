package com.example.backend.controller;

import com.example.backend.model.Todo;
import com.example.backend.repository.TodoRepository;
import com.example.backend.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")

public class BackendController {

    private final TodoService todoService;

    public BackendController(TodoService todoService){
        this.todoService = todoService;
    }

    @PostMapping("todo")
    public Todo addTodo(@RequestBody Todo todo) {
        todoService.getTodoRepository().addToDo(todo);
        return todo;
    }
//    @GetMapping("todo")
//    public String getAllTodos(){
//        todoService.getTodoRepository().toString();
//    }
}
