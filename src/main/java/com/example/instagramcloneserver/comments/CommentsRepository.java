package com.example.instagramcloneserver.comments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {

    List<Comments> findByPostid(int id);
}
