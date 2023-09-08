package com.example.instagramcloneserver.credentials;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Credentials {
    @Id
    @GeneratedValue
    int id;
    String email;
    String pass;

    public Credentials() {}

    public Credentials(int id, String email, String pass) {
        this.id = id;
        this.email = email;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
