package com.todo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Todo {



    public Todo(String name, String description, Boolean done) {
        this.name = name;
        this.done = done;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private Boolean done;

    @Column
    private String description;

}