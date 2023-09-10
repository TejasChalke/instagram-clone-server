package com.example.instagramcloneserver.friends;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

import java.io.Serializable;

class MyKey implements Serializable {
    private int user;
    private int follower;
}

@Entity
@IdClass(MyKey.class)
public class Friends {

    @Id
    int user;
    @Id
    int follower;

    public Friends() {
    }

    public Friends(int user, int follower) {
        this.user = user;
        this.follower = follower;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }
}
