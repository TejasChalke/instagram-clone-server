package com.example.instagramcloneserver.review;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int pendingid;

    public Review() {}

    public Review(int pendingid) {
        this.pendingid = pendingid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPendingid() {
        return pendingid;
    }

    public void setPendingid(int pendingid) {
        this.pendingid = pendingid;
    }
}
