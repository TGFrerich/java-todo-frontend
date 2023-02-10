package com.example.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class BackendControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void addTodo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/todo")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                       {
                       "id" : "1",
                       "description" : "hallo",
                        "status" : "OPEN"}
                        """)
                )
                .andExpect(status().isOk())
                .andExpect(content().json("""
 {
                        "description" : "hallo",
                        "status" : "OPEN"
                         }
""")).andExpect(jsonPath("$.id").isNotEmpty());

    }


    @Test
    void getAllTodos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/todo"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));

    }

    @Test
    void getTodoById() {
    }

    @Test
    void putTodo() {
    }

    @Test
    void deleteTodo() {
    }
}