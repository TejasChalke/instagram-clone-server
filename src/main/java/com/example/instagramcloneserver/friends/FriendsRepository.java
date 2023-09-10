package com.example.instagramcloneserver.friends;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendsRepository extends JpaRepository<Friends, Integer> {

    List<Friends> findByUser(int user);

    List<Friends> findByFollower(int follower);
    Friends findByUserAndFollower(int user, int follower);

}
