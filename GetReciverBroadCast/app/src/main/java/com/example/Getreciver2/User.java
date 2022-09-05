package com.example.Getreciver2;

import java.io.Serializable;

public class User implements Serializable {
    private String Name,Email;

    public User() {
    }

    public User(String name, String email) {
        Name = name;
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
