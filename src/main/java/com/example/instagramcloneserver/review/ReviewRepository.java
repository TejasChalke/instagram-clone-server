package com.example.instagramcloneserver.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Modifying
    @Query(value = "delete from review where pendingid=:pendingid", nativeQuery = true)
    void deleteByPendingid(int pendingid);
}
