package com.example.instagramcloneserver.userposts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserpostsRepository extends JpaRepository<Userposts, Integer> {
    @Query(value = "Select * from userposts where userid = :userid or userid in (Select user from friends where follower = :userid)", nativeQuery = true)
    List<Userposts> findByUserid(int userid);
}
