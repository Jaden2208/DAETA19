package com.example.daeta19;

import java.util.ArrayList;

public class Hire {
   // private Image store_img;
    private String store;
    private String todo;
    private String date_day;
    private String time;
    private String pay;


    public Hire(String store, String todo, String date_day, String time, String pay) {
       // this.store_img = store_img;
        this.store = store;
        this.todo = todo;
        this.date_day = date_day;
        this.time = time;
        this.pay = pay;
    }



/*
    public Image getStore_img() {
        return store_img;
    }

    public void setStore_img(Image store_img) {
        this.store_img = store_img;
    }
    */


    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getDate_day() {
        return date_day;
    }

    public void setDate_day(String date_day) {
        this.date_day = date_day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }
}
