package com.todo.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.todo.dto.TodoDTO;
import com.todo.service.TodoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(produces = "application/json", value = "Operations pertaining to manager blood donors in the application")
@RequestMapping("/api")
@Data
public class TodoController {

    private final TodoService todoService;

    @RequestMapping(value= "/todo", method = RequestMethod.POST)
    @ApiOperation(value = "Create a new donor", response = ResponseEntity.class)
    public ResponseEntity createTodo(@RequestBody TodoDTO todoDTO){
        todoService.createTodo(todoDTO);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value= "/todo/{id}/status", method = RequestMethod.PUT)
    public ResponseEntity updateTodoDoneStatus(@PathVariable int id, @RequestBody ObjectNode json){
        todoService.updateTodoDoneStatus(id, json.get("done").asBoolean());
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value= "/todo/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateTodo(@PathVariable int id, @RequestBody TodoDTO todoDTO){
        todoService.updateTodo(todoDTO, id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value= "/todo/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTodo(@PathVariable int id){
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }

}