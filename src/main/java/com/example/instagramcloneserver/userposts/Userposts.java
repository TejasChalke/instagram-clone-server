package com.example.instagramcloneserver.userposts;

import jakarta.persistence.*;

@Entity
public class Userposts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int userid;
    String description;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Lob
    @Column(length = 1000)
    private byte[] image;
    int likes;

    public Userposts() {}

    public Userposts(int userid, String name, String description, byte[] image, int likes) {
        this.userid = userid;
        this.name = name;
        this.description = description;
        this.image = image;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
