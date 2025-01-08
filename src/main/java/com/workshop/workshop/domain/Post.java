package com.workshop.workshop.domain;


import com.workshop.workshop.dto.AuthorDTO;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

import java.util.Date;

import java.util.Objects;


public class Post implements Serializable {

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;

    public Post() {

    }

    public Post(String id, Date date, String title, String body, AuthorDTO author) {
        super();
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;

    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }



}
