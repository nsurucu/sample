package com.todo.service;


import com.todo.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    List<TodoDTO> getTodos();
    TodoDTO getTodo(int id);
    void createTodo(TodoDTO todoDTO);
    void deleteTodo(int id);
    void updateTodo(TodoDTO todoDTO, int id);
    void updateTodoDoneStatus(int id, boolean status);


}