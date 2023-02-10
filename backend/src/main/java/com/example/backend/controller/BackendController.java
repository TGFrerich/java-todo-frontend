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
        return todoService.addTodo(todo);
    }
    @GetMapping("todo")
    public List<Todo> getAllTodos(){
        return todoService.getTodoRepository().getTodoList();
    }
    @GetMapping("todo/{id}")
    public Todo getTodoById(@PathVariable String id) {
        return todoService.getTodoById(id);
    }
    @PutMapping ("todo/{id}")
    public Todo putTodo(@PathVariable String id, @RequestBody Todo todo){
        return todoService.putTodo(id, todo);
    }

    @DeleteMapping("todo/{id}")
    public Todo deleteTodo(@PathVariable String id) {
        return todoService.deleteTodo(id);
    }
}
