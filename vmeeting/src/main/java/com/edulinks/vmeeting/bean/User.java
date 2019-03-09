package com.edulinks.vmeeting.bean;

// import javax.persistence.Entity;

// @Entity
public class User {
    private int id;
    private String name;

    public User(){

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