package com.example.moi.model;

public class User {
    long id;
    String Name;
    String Password;

    public User(long id, String name, String password) {
        this.id = id;
        Name = name;
        Password = password;
    }

    public User(String name, String password) {
        Name = name;
        Password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
