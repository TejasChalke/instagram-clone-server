package com.example.instagramcloneserver.pendingcomments;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pendingcomments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int userid;

    int postid;
    String uname;
    String comment;

    public Pendingcomments() {}

    public Pendingcomments(int userId, int postId, String uname, String comment) {
        this.userid = userId;
        this.postid = postId;
        this.uname = uname;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userid;
    }

    public void setUserId(int userid) {
        this.userid = userid;
    }

    public int getPostId() {
        return postid;
    }

    public void setPostId(int postid) {
        this.postid = postid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
