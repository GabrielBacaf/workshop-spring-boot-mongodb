package com.workshop.workshop.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;


    private String id;
    private String name;
    private String email;

    public User() {


    }

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;

    }


    List<Post> Userposts = new ArrayList<Post>();

    List<Comment> UserComment = new ArrayList<Comment>();

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Post> getUserposts() {
        return Userposts;
    }

    public List<Comment> getUserComments() {
        return UserComment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
