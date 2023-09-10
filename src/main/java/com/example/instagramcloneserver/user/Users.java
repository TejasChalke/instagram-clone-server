package com.example.instagramcloneserver.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Users {

    @Id
    @GeneratedValue
    int id;
    String name;
    String uname;
    String image;
    String description;
//    int followers;
//    int following;

    public  Users() {}

    public Users(int id, String name, String uname, String image, String description) {
        this.id = id;
        this.name = name;
        this.uname = uname;
        this.image = image;
        this.description = description;
//        this.followers = followers;
//        this.following = following;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public int getFollowers() {
//        return followers;
//    }
//
//    public void setFollowers(int followers) {
//        this.followers = followers;
//    }
//
//    public int getFollowing() {
//        return following;
//    }
//
//    public void setFollowing(int following) {
//        this.following = following;
//    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", uname='" + uname + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
