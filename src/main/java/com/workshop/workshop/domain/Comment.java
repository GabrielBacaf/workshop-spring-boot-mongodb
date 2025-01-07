package com.workshop.workshop.domain;

import java.util.Date;

public class Comment {

    private String  id;
    private String text;
    private Date date;


    public Comment( String text, Date date) {
        this.text = text;
        this.date = date;

    }
    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }



}
