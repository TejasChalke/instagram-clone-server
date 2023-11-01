package com.example.instagramcloneserver.pendingcomments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PendingcommentsRepository extends JpaRepository<Pendingcomments, Integer> {
    List<Pendingcomments> findByUseridAndComment(int userid, String comment);

    @Query(value = "select * from pendingcomments where id in (select pendingid from review)", nativeQuery = true)
    List<Pendingcomments> findPendingForReview();
}
