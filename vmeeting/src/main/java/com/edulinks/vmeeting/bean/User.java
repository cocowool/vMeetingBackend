package com.edulinks.vmeeting.bean;

// import javax.persistence.Entity;

// @Entity
public class User {
    private int id;
    private String name;

    public User(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getUserId(){
        return this.id;
    }

    public String getUserName(){
        return this.name;
    }

    public void setUserId(int id){
        this.id = id;
    }

    public void setUserName(String name){
        this.name = name;
    }
}