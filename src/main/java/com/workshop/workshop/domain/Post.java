package com.workshop.workshop.domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Post {
    private String id;
    private String title;
    private Date date;
    private String body;

    public Post(String title, Date date, String body) {
        this.title = title;
        this.date = date;
        this.body = body;

    }

    List<Comment> Postcomments = new ArrayList<Comment>();



    public String getId() {
        return id;
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
    public List<Comment> getPostcomments() {
        return Postcomments;
    }

}
