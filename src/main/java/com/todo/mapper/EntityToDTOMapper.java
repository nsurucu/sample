package com.todo.mapper;

import com.todo.dto.TodoDTO;
import com.todo.entity.Todo;

public  class EntityToDTOMapper {

    public static TodoDTO createDTOFromEntity(Todo todo){
        TodoDTO todoDTO = new TodoDTO();
        todoDTO.id = todo.getId();
        todoDTO.name = todo.getName();
        todoDTO.description = todo.getDescription();
        todoDTO.done = todo.getDone();

        return todoDTO;
    }

    public static Todo createEntityFromDTO(TodoDTO todoDTO){
        return new Todo(todoDTO.name,todoDTO.description, todoDTO.done);
    }
}