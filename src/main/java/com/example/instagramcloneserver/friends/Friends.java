package com.example.instagramcloneserver.friends;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Friends {

    @Id
    int followee;
    int follower;

    public Friends() {
    }

    public Friends(int followee, int follower) {
        this.followee = followee;
        this.follower = follower;
    }

    public int getFollowee() {
        return followee;
    }

    public void setFollowee(int followee) {
        this.followee = followee;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }
}
