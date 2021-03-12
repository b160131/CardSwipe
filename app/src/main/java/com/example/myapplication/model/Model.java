package com.example.myapplication.model;


public class Model {


    public String id;
    public String text;

    public Model(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return id + " " +
                "text=" + text + " \n";
    }
}
