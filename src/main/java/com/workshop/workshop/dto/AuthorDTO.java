package com.workshop.workshop.dto;

import com.workshop.workshop.domain.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {

    private String id;
    private String name;

    public AuthorDTO(){
        super();
    }

    public AuthorDTO(User obj) {
        id = obj.getId();
        name = obj.getName();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
